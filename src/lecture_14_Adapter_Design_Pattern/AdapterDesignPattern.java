package lecture_14_Adapter_Design_Pattern;

// Definition:
// Adapter Converts the interface of a class into another interface that client expects.
// Adapter lets classes work together that couldn't otherwise because of incompatible interface.

// 1. Target interface expected by the client
interface IReports {
    // now takes the raw data string and returns JSON
    String getJsonData(String data);
}


// 2. Adaptee: provides XML data from a raw input
class XMLDataProvider {
    // Expect data in "name:id" format (e.g. "Alice:42")
    String getXmlData(String data) {
        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String id   = data.substring(sep + 1);
        // Build an XML representation
        return "<user>" + "<name>" + name + "</name>" + "<id>"   + id   + "</id>" + "</user>";
    }
}


// 3. Adapter: implements IReports by converting XML → JSON
class XMLDataProviderAdapter implements IReports {
    private final XMLDataProvider xmlDataProvider;

    public XMLDataProviderAdapter(XMLDataProvider xmlDataProvider) {
        this.xmlDataProvider = xmlDataProvider;
    }

    @Override
    public String getJsonData(String data) {
        // 1. Get XML from the adaptee
        String xml = xmlDataProvider.getXmlData(data);

        // 2. Naively parse out <name> and <id> values
        int startName = xml.indexOf("<name>") + 6;
        int endName   = xml.indexOf("</name>");
        String name   = xml.substring(startName, endName);

        int startId = xml.indexOf("<id>") + 4;
        int endId   = xml.indexOf("</id>");
        String id    = xml.substring(startId, endId);

        // 3. Build and return JSON
        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";
    }
}


// 4. Client code works only with IReports
class Client {
    public void getReport(IReports report, String rawData)  {
        System.out.println("============ Getting Report ============");
        System.out.println(report.getJsonData(rawData));
    }
}


public class AdapterDesignPattern {
    static void main() {

        // 1. Create the adaptee
        XMLDataProvider provider = new XMLDataProvider();

        // 2. Make our adapter
        IReports reports = new XMLDataProviderAdapter(provider);

        // 3. Give it some raw data
        String rawData = "Rohit:137";

        // 4. Client prints the JSON
        Client client = new Client();

        client.getReport(reports, rawData);
    }
}
