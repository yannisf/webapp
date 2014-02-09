package fraglab.webapp.axis.client;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.httpclient.Header;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class HelloServiceClient {

    private HelloServiceStub stub;

    public static void main(String[] args) throws RemoteException {
        HelloServiceClient client = new HelloServiceClient();
        client.stub = new HelloServiceStub();
        client.setupAuthentication();
        client.hello();
        client.personalizedHello("yannisf");
    }

    private void setupAuthentication() {
        Options options = stub._getServiceClient().getOptions();
        HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
        auth.setPreemptiveAuthentication(true);
        auth.setPassword("yannisf");
        auth.setUsername("yannisf");
        options.setProperty(HTTPConstants.AUTHENTICATE, auth);
    }

    public void hello() throws RemoteException {
        HelloServiceStub.Hello hello = new HelloServiceStub.Hello();
        System.out.println(stub.hello(hello).get_return());
    }

    public void personalizedHello(String name) throws RemoteException {
        HelloServiceStub.PersonalizedHello personalizedHello = new HelloServiceStub.PersonalizedHello();
        personalizedHello.setName("yannisf");
        System.out.println(stub.personalizedHello(personalizedHello).get_return());
    } 
}
