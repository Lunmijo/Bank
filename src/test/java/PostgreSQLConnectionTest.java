import connection.PostgreSQLConnection;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PostgreSQLConnectionTest {

    @Test
    public void connectionTest() {

        PostgreSQLConnection.connect();

        assertNotNull(PostgreSQLConnection.getConnection());
    }
}
