package cn.e3mall.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastDfsTest {
	@Test
	public void testUpload() throws Exception{
		ClientGlobal.init("D:/program/eclipse/eclipse-workspace/java-workspace/e3mall/e3-manager-web/src/main/resources/conf/client.conf");
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer,storageServer);
		String[] strings = storageClient.upload_file("C:\\Users\\cxh\\Pictures\\lWwgFLU.jpg", "jpg", null);
		for(String string:strings) {
			System.out.println(string);
		}
	}
}
