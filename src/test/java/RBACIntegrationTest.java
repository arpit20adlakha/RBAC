import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import app.RBAC;
import app.RolesDAOImpl;
import app.UserDAOImpl;
import app.entities.Operation;

import static org.assertj.core.api.Assertions.assertThat;


public class RBACIntegrationTest {
    private static String TEST_USER_ID = "tester";

    private static RBAC rbac = new RBAC(RolesDAOImpl.create(), UserDAOImpl.create());

    @BeforeEach
    public void beforeEach(){
        // In real world this should be a sql query or sth eqv which interacts with the persistence layer directly
        UserDAOImpl.create().removeAllRoles(TEST_USER_ID);
    }

    @Test
    public void shouldFailIfNoRoleIsAddedTest(){
        String result = rbac.executeOperatation(Operation.CHECKROLE, List.of(TEST_USER_ID, "github", "read"));
        assertThat(result).contains("FAILURE");
    }

    @Test
    public void shouldBeAbleToAddRoleAndAllowAccessTest(){
        String result = rbac.executeOperatation(Operation.ADD, List.of(TEST_USER_ID, "engineer"));
        assertThat(result).contains("SUCCESS");
        result = rbac.executeOperatation(Operation.CHECKROLE, List.of(TEST_USER_ID, "github", "read"));
        assertThat(result).contains("SUCCESS");
    }

    @Test
    public void shouldBeAbleToRemoveRoleTest(){
        rbac.executeOperatation(Operation.ADD, List.of(TEST_USER_ID, "manager"));

        String result = rbac.executeOperatation(Operation.CHECKROLE, List.of(TEST_USER_ID, "payroll", "read"));
        assertThat(result).contains("SUCCESS");

        result = rbac.executeOperatation(Operation.REMOVE, List.of(TEST_USER_ID, "manager"));
        assertThat(result).contains("SUCCESS");

        result = rbac.executeOperatation(Operation.CHECKROLE, List.of(TEST_USER_ID, "payroll", "read"));
        assertThat(result).contains("FAILURE");
    }

    @Test
    public void shouldBeAbleToAddMultipleRoles(){
        String result = rbac.executeOperatation(Operation.ADD, List.of(TEST_USER_ID, "manager", "engineer"));
        assertThat(result).contains("SUCCESS");

        result = rbac.executeOperatation(Operation.CHECKROLE, List.of(TEST_USER_ID, "aws", "read"));
        assertThat(result).contains("SUCCESS");

        result = rbac.executeOperatation(Operation.CHECKROLE, List.of(TEST_USER_ID, "github", "read"));
        assertThat(result).contains("SUCCESS");

    }
}
