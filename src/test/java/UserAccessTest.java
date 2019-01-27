import connection.PostgreSQLConnection;
import crud_classes.implementations.UsersAccess;
import db_entity.db_objects_impl.UserImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class UserAccessTest {

    @BeforeClass
    public static void connectDB() {
        PostgreSQLConnection.connect();
    }

    private UserImpl getTestUser() {
        UserImpl user = new UserImpl();
        user.setID(1);
        user.setLastName("Pupkin");
        user.setFirstName("Pedro");
        return user;
    }

    private UserImpl getUpdatedTestUser() {
        UserImpl user = new UserImpl();
        user.setID(1);
        user.setLastName("Papkin");
        user.setFirstName("Pedro");
        return user;
    }

    @Test
    public void userSaveTest() {
        UsersAccess usersAccess = new UsersAccess();
        usersAccess.save(this.getTestUser());

        assertNotNull(usersAccess.findByID(this.getTestUser()
                .getID()));
    }

    @Test
    public void userDeleteTest() {
        UsersAccess usersAccess = new UsersAccess();
        usersAccess.delete(this.getTestUser());

        assert(usersAccess.findByID(this.getTestUser()
                .getID()) == null);
    }

    @Test
    public void userUpdateTest() {

        UsersAccess usersAccess = new UsersAccess();
        usersAccess.update(this.getUpdatedTestUser());
        assert(usersAccess.findByID(this.getUpdatedTestUser().getID()) != this.getTestUser());
    }
}
