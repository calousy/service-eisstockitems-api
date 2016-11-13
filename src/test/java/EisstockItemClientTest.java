import org.junit.Test;
import org.meisl.EisstockItemClient;

public class EisstockItemClientTest {

	private EisstockItemClient _client = new EisstockItemClient("http://localhost:8080/");
	
	@Test
	public void test() {
		_client.getItemByRegId("34-1914-06-01");
	}

}
