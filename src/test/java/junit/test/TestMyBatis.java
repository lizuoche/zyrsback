package junit.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.text.ParseException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory.Result;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.cn.zyrs.domain.User;
import com.cn.zyrs.service.IUser;
import com.cn.zyrs.utils.ChineseUtils;
import com.cn.zyrs.utils.DateUtils;
import com.cn.zyrs.utils.FileUtils;
import com.cn.zyrs.utils.JsonHelper;
import com.cn.zyrs.utils.OrderCodeFactory;
import com.cn.zyrs.utils.PCUtils;
//import com.cn.zyrs.utils.RSAUtils;

@RunWith(SpringJUnit4ClassRunner.class)
// 琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {
	private static Logger log = Logger.getLogger(TestMyBatis.class);
	@Resource(name = "userService")
	private IUser userService;

	final static String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final static String DATABASE_URL = "jdbc:sqlserver://192.168.1.10:1433;databaseName=yc_demo";
	final static String DATABASE_USRE = "sa";
	final static String DATABASE_PASSWORD = "111111";

	
	/**
	 * 
	 * 业  务: 测试MD5加密字符串 <br>
	 * 英文名: MD5Secret 
	 * 功能号: TODO
	 * 时  间: 2017年3月4日 下午3:55:15
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@SuppressWarnings("restriction")
	public static String MD5Secret(String str) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		// 加密后的字符串
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;

	}

	/**
	 * 
	 * 业  务: 测试存储过程 <br>
	 * 英文名: testCc 
	 * 功能号: TODO
	 * 时  间: 2016年8月10日 下午1:42:18
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	public static void testCC() {
		try {
			Class.forName(DRIVER_CLASS);
			Connection connection = DriverManager.getConnection(DATABASE_URL,
					DATABASE_USRE, DATABASE_PASSWORD);
			CallableStatement callableStatement = connection
					.prepareCall("{call GETNEWSERIAL(?,?)}");
			// 返回值
			callableStatement.setString(1,
					"98538517-BC64-429E-83FF-B07A99A00FA8");
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			// 输出参数
			// callableStatement.registerOutParameter(2, Types.VARCHAR);
			// 输出参数
			// callableStatement.registerOutParameter(3, Types.VARCHAR);
			// 输入参数
			callableStatement.execute();
			// 获得返回值
			// int returnValue = callableStatement.getInt(1);
			// 获得输入参数
			// String groupName = callableStatement.getString(1);
			// 获得输出参数
			String memo = callableStatement.getString(2);
			// System.out.println(returnValue);
			// System.out.println(groupName);
			System.out.println(memo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Test
	public static void testToMap() throws Exception {
		// String js =
		// getURLContent("http://localhost:8888/zyrsback/order/showOrder");
		// String js1=js.substring(1,100);
		// String js2=js1+"}";
		String js2 = "{ 'type ' : 'suit' , 'suitBom' :{ 'id ': 'be4dec89-6337-47b6-b1a7-1a179b8ee119 ', 'small_image ': 'TextureMaterial/suit_texture/2472ca8e-c1b3-4c9b-853f-da7d5413a2d5.jpg ', 'english_brand_name ': 'collection ', 'style ': 'suitBom ', 'remark ': ' ', 'name ': '布料 ', 'china_brand_name ': '我的收藏 ', 'normal_image ': 'TextureMaterial/suit_texture/ ', 'big_image ': 'TextureMaterial/suit_texture/f0a3a004-299c-4833-814f-7f4882acc125.jpg ', 'code ': 'A4363 '}, 'shirtBom ':{ 'id ': 'f9fd0ec0-9748-4d4b-a3ab-317617fd157d ', 'small_image ': 'TextureMaterial/shirt_texture/8012e0b9-62de-488a-bfc2-7d83ac62ef34.jpg ', 'english_brand_name ': 'shirt_boss ', 'style ': 'shirtBom ', 'remark ': ' ', 'name ': '衬衫布料 ', 'china_brand_name ': 'Boss牌 ', 'normal_image ': 'TextureMaterial/shirt_texture/ ', 'big_image ': 'TextureMaterial/shirt_texture/a04e1d5a-6cce-4211-89b2-3f8c121be716.jpg ', 'code ': 'P855 '}, 'suitButton ':{ 'id ': 'acd541f1-bce4-4a96-b277-5383c937550d ', 'modelname ': 'suitButton001 ', 'name ': '12星座扣 ', 'english_brand_name ': 'qingchuankalan ', 'china_brand_name ': '青川卡兰 ', 'code ': '星座B款 ', 'small_image ': 'Commodity/suitButton_commodity/052824e3-3e7f-4dfb-a3b6-a0c074208793.jpg ', 'style ': 'suitButton ', 'remark ': ' '}, 'tieBom ':{ 'id ': '39d00808-b6ce-4156-8427-6db3cd29fed0 ', 'small_image ': 'TextureMaterial/tie_texture/be633f33-e4ac-4ae6-a2d7-0b761c9dfd24.jpg ', 'english_brand_name ': 'qingchuankalan ', 'style ': 'tieBom ', 'remark ': ' ', 'name ': '领带布料D款 ', 'china_brand_name ': '青川卡兰 ', 'normal_image ': 'TextureMaterial/tie_texture/ ', 'big_image ': 'TextureMaterial/tie_texture/1512c1c5-3355-4b55-b02c-83a2aa9005fc.jpg ', 'code ': 'D款 '}, 'kouyanBom ':{ 'id ': 'f35eb562-a4be-4d04-a5ee-8472b2f42492 ', 'small_image ': 'TextureMaterial/kouyan_texture/e8a0849d-95d4-45c8-8e9c-077560991404.jpg ', 'english_brand_name ': 'qingchuankalan ', 'style ': 'kouyanBom ', 'remark ': ' ', 'name ': '扣眼A型 ', 'china_brand_name ': '青川卡兰 ', 'normal_image ': 'TextureMaterial/kouyan_texture/ ', 'big_image ': 'TextureMaterial/kouyan_texture/cceac5ee-c0f3-4474-9d9b-29adb53b5ef9.jpg ', 'code ': 'A型 '}, 'collar ':{ 'id ': 'f781c425-260e-434a-bdc5-b4e861df97d0 ', 'style ': 'collar ', 'type ': '西服领形 ', 'name ': '戗驳领 ', 'workshopname ': '22 ', 'remark ': ' ', 'modelname ': 'collar_003 ', 'image ': ' ', 'image1 ': 'json/suit/image/2aa747ea-11ec-4b02-b3da-c52f82707dbc.jpg ', 'image2 ': 'upload/PC版缩略图/ ', 'image3 ': 'upload/备用图/ '}, 'buttonNum ':{ 'id ': '610a0901-8058-4b2f-991b-ccdc66da1257 ', 'style ': 'buttonNum ', 'type ': '西服袖扣数目 ', 'name ': '三粒扣 ', 'workshopname ': 'dfd ', 'remark ': ' ', 'modelname ': 'buttonnum3 ', 'image ': ' ', 'image1 ': 'json/suit/image/76bab685-cf33-4d61-99cc-9624e8c7d9b9.jpg ', 'image2 ': 'upload/PC版缩略图/ ', 'image3 ': 'upload/备用图/ '}, 'placket ':{ 'id ': 'c150479e-aa89-460e-adcc-ea1c691f719a ', 'style ': 'placket ', 'type ': '西服门襟 ', 'name ': '单门襟四粒扣+直摆 ', 'workshopname ': 'w ', 'remark ': ' ', 'modelname ': 'placket_007 ', 'image ': ' ', 'image1 ': 'json/suit/image/db385ef2-43c2-41ed-ba89-e34f8e1f4a82.jpg ', 'image2 ': 'upload/PC版缩略图/ ', 'image3 ': 'upload/备用图/ '}, 'back ':{ 'workshopname ': '后片2 ', 'image ': ' ', 'image3 ': 'upload/备用图/ ', 'modelname ': 'back_003 ', 'name ': '单开叉 ', 'style ': 'back ', 'remark ': ' ', 'id ': 'cad5a8c9-c316-4b1e-b267-1c93bb21f9ee ', 'type ': '西服后片 ', 'image1 ': 'json/suit/image/60c84220-5009-48b7-a17f-911c960d56f5.jpg ', 'image2 ': 'upload/PC版缩略图/ '}, 'breastPocket ':{ 'id ': 'e1c4627e-84ba-437f-8303-3415adf929e3 ', 'style ': 'breastPocket ', 'type ': '西服胸袋 ', 'name ': '贴袋 ', 'workshopname ': '胸袋1 ', 'remark ': ' ', 'modelname ': 'breastPocket_001 ', 'image ': ' ', 'image1 ': 'json/suit/image/e4128df2-6e09-47e2-a0dd-d63a8fe07567.jpg ', 'image2 ': 'upload/PC版缩略图/ ', 'image3 ': 'upload/备用图/ '}, 'buff ':{ 'id ': '9c6806cd-dde0-4dc4-b6f7-9af237dc4ce2 ', 'style ': 'buff ', 'type ': '西服袖子 ', 'name ': '西服普通袖子 ', 'workshopname ': '袖口2 ', 'remark ': ' ', 'modelname ': 'buff_001 ', 'image ': ' ', 'image1 ': 'json/suit/image/1983981e-36e4-4894-bf07-69daf3ea459f.jpg ', 'image2 ': 'upload/PC版缩略图/ ', 'image3 ': 'upload/备用图/ '}, 'pocket ':{ 'id ': '59a59f72-2cfd-4dc0-9ee9-ce6e27612acf ', 'style ': 'pocket ', 'type ': '西服口袋 ', 'name ': '双袋盖 ', 'workshopname ': '口袋2 ', 'remark ': ' ', 'modelname ': 'pocket_002 ', 'image ': ' ', 'image1 ': 'json/suit/image/6ddf5cc2-198c-4da6-a8cc-6aa6dfc2aa41.jpg ', 'image2 ': 'upload/PC版缩略图/ ', 'image3 ': 'upload/备用图/ '}, 'buttonEye ':{ 'workshopname ': '无 ', 'image ': ' ', 'image3 ': 'upload/备用图/ ', 'modelname ': 'buttonEye_buttonnum4 ', 'name ': '袖口四粒扣扣眼 ', 'style ': 'buttonEye ', 'remark ': ' ', 'id ': 'f9805845-6d99-443e-aaf3-b958c7a05c2a ', 'type ': '西服扣眼 ', 'image1 ': 'json/suit/image/ ', 'image2 ': 'upload/PC版缩略图/ '}}";
//		System.err.println(js2);
		Map<?, ?> map = null;
		try {
			map = JsonHelper.toMap(js2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(map.toString());
		System.err.println(JsonHelper.toMap(map.get("suitbom").toString()).get("id "));
//		System.out.println(map1.get("type"));
	}

	/**   
	    * 程序中访问http数据接口   
	    */
	public static String getURLContent(String urlStr) {
		/** 网络的url地址 */
		URL url = null;
		/** http连接 */
		HttpURLConnection httpConn = null;
		/**//** 输入流 */
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(urlStr);
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setDoOutput(true);
			httpConn.setRequestMethod("POST");
			in = new BufferedReader(new InputStreamReader(
					httpConn.getInputStream(), "UTF-8"));
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {

		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
		String result = sb.toString();
		System.out.println(result);
		return result;
	}
	
	/**
	 * 图片转Base64格式字符串
	 */
	
    @SuppressWarnings("restriction")
	public static String GetImageStr()  
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        String imgFile = "C://Users/Administrator/Desktop/xxx.png";//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }    
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }  
	
	/**
	 * 接受并保存以base64格式上传的文件
	 */
	@SuppressWarnings("restriction")
	public static void uploadBase64(String base64Data) {
		String savePath = "D:/";
		String fileName = UUID.randomUUID().toString();
		String url = savePath + "/" + fileName + ".png";
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			File outFile = new File(url);
			OutputStream ro = new FileOutputStream(outFile);
			byte[] b = decoder.decodeBuffer(base64Data);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			ro.write(b);
			ro.flush();
			ro.close();
		} catch (Exception e) {
			log.error("Base64转换图片失败！", e);
		}
		log.info("Base64转换图片成功！");
	}
	
	
//	public static void testRSA(String RSA) throws Exception{
//		RSA="F+QlZCmdYltTuBHUW5Y1DYud9RnapTzu8eUR7SKA6pdy+nmjQ+IgR6CAjXyYc9xXPEKHmlu452IR/uDaSei+5j4wBWIFXrzL0DP4zC0tbwAhPkePWrYnJ54EPBFAI2Cpuksfq+McVUj1N1qfhxyZTgAqnR6c3KZtpZabZj7Vugc=";
//		String key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMFzdM2OoRftexmcWzHKv0ejNcXxx6CDU8hGt2ZMic1jr6bDe01gvBsUG9h3MyQR6D1NLco8IqM1T5zd9pEecJdHu+YoagqWgUHFgin5YYdTgoltx7LQmpU7EmEJstGUnDU3IweNlZ2hVp3FeUYj2vChyA+w5sJMXpjhQNNGMY9AgMBAAECgYBVHhvypiMziAZ2CloF2pO3TZTHd87CTYZ7xMHFfT/U41vSIIkMTtf1gi+OW0RhRo/NCTxwk20aKsbQ2sk2qRIYeegIOLo8zoKaCypRxo2poz9uF1RlLxT8d2s8uKNXCEXumaEbtN2a53nkRlVidPXUKTJW64KynTRsBi8l/REDcQJBAO5UnHUhgy7XEX5ZmzQ0t9/485Xq5sLccywpOfNHIpej2E+Y6XrUUd/Is9kBRU+Ac6lnDzFlSJNJQkkxBvS0Lb8CQQDPyw4tRyFf7bnVIPxHZkQGWVyHm6upbBPQKgq8zOl1SZOWobpgrmeMgKy5MkTbIZEo8Oggfp5QM+sFPeVwTQMDAkEAn9Lz3QStQUMOwyl6EEduK296gkW1nGVTgwDekMtaYlCI5dAIestZYHXqTZMxlL/yUF8BbEGcqtDM9+I95OnTZwJBAMqZhiIZd24L4KPwfGm1SWATYweJfa88BHlzdHKvLHVCHtfAqnM3uRiiIUaUv9QUf282rG16Zyt145GBzyJWxDcCQB6uKqIREDBJtju0RzU6Qo9sZQkZe3pz16zQVsnpI8pA3saEd2Z0k1jaHv6/fPE9GWmktmGbH1Uw/Gku9ZAQRVI=";
////		RSAPrivateKey  prikey = (RSAPrivateKey)key;		
//		//解密后的明文  
////        String ming = RSAUtils.decryptByPrivateKey(RSA, prikey);
//        
//        byte[] decodedData = RSAUtils.decryptByPublicKey(RSA.getBytes(), key);  
//        String target = new String(decodedData);  
//        
//        System.out.println(target);
//		
//	}
	
	/**
	 * 
	 * 业  务: 测试HttpClient访问URL <br>
	 * 英文名: testHttpClient 
	 * 功能号: TODO
	 * 时  间: 2017年3月4日 上午9:21:04
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	 @SuppressWarnings({ "deprecation", "resource" })
	public static String testHttpClient(String url,String key){
//        String urlNameString = "https://api.weixin.qq.com/sns/userinfo?access_token=TOKEN&openid=OPENID";
        String result="";
        
          try {
                // 根据地址获取请求
                HttpGet request = new HttpGet(url);//这里发送get请求
                //设置密钥
                if(key != null){
                	request.setHeader("JSESSIONID", key);
                }
                // 获取当前客户端对象
                HttpClient httpClient = new DefaultHttpClient();
                // 通过请求对象获取响应对象
                HttpResponse response = httpClient.execute(request);
                
                // 判断网络连接状态码是否正常(0--200都数正常)
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result= EntityUtils.toString(response.getEntity(),"utf-8");
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }
        return result;
    }
	 
	 public static int inc(int temp) { 
         if (temp > 0) { 
             return temp * 2 ; 
         } 
         return -1 ; 
     } 
	 
	public static void main(String[] args) throws ParseException, JSONException, UnsupportedEncodingException {
		// testCC();
		// OrderCodeFactory.makeOrderCode();
		// System.out.println(DateUtils.dateToTimestamp("2016-08-15 09:12:05"));
		// try {
		// System.out.println(MD5Secret("王元春"));
		// } catch (NoSuchAlgorithmException e) {
		// e.printStackTrace();
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// UserController uc=new UserController();
		// User user = ("5D134EDB-09E8-4A57-AF7B-6916751CEE68");
		// System.out.println(user);
		// getURLContent("http://localhost:8888/zyrsback/login/userLogin?username=wyc&password=111");
		// try {
		// testToMap();
		// } catch (JSONException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// File file = null;
		// file = new File(
		// "F:\\eclipse_workspace_zyrs_addorder\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\zyrsback\\upload\\stylefinished\\短袖衬衫\\领子");
		// System.out.println(FileUtils.getPNGeNames(file).toString());
		// 获取本机真实IP
		// PCUtils.getRealIP();
		//Base64字符串和图片之间互转
//		uploadBase64("/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAEsASwDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4 Tl5ufo6erx8vP09fb3 Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3 Pn6/9oADAMBAAIRAxEAPwDygCngUAU4Cuw4wApwFKBTgKZIAU4CgCngUxCAU4ClApQKYhAKcBSgU4CnYVxAKUCnAUuKYrjcUuKdinYoEMxS4p KckbSNtRSx9AKYDETc4ByATyQM1qw Gr 6hjktPJuN cqj7SnTruwPyz0qvFZyq3 rYsAWYKM7R6muq8OSlB7A9a5Z1mn7p1QoJx97cy1 H/imRd0ekySL/eSRGH5hqqXPhLXLP8A4 bEw 8kiKP1NeqDWr7StaisLmAwwSbWilDnEpUhiAykcAgAjuOuQ3PayWqskOo TA825coxI3A8YUk4DZPHr04zkL28ivq8TwG0 H/im9YiDR5SAA25nRVIPTDEgH8K5rFfXnSvm7x5pE9h4w1mQLLJbm7LGfyyEDyKJdmemQH9ecZrSlVcnZmVWkoK6OUxSYqTFJit7GFyPFJipMUmKQERFIRUpFNIoHciIpCKkIppFKw7kZFNIqUimkUhkRFNIqQimkUhkRFNIqUimEVI0yIikxUhFNxSKHgU8CkAp4FUSAFPAoApwFMQAU4ClApwFMkQCngUAU4CqFcAKUClApwFAhAKUCnAVPawG4uUi5Ck8tjp7fWiTUVdjjFydkQAVet9KuZ8HZsU934/Suht9OgtI/ljG7ux5JpVZpJxGg61zyxH8qOmOHX2mN03w7YqN15um9gSo/Sr39kpArC3RI4jkgAH8OSSTx/kdK1rWySJAZTlvSnTFQvYAfpWEpyluzeMIx2RXsVhUKkUCof4nxy31rQ8PeGJINVaQBTajJjB5654wc9PX6H6VVQiRAowCRk16BpqJ5aeX2HWpKM7xZo6T6KqQWpkvLdGuYJipxHsZdy7h0LKThTwcZ/hyOiRp5rO0igJRfLUu4x19B3/AP1j3rP1oPKba2Dr5eTJIgJ3Ej7ueen3uo6gelbWnJttFoAehaGSOJ2Lq4O1zj7w7dckkZIwP4Tk9KyNfhgvpG0 7gWe3mhAdGHUZP5HgHPbFbiyAnHeueuXkufFDxYAWJVUEDqMbufzNAHlPiH4a3VhP5unTeZYkAbpydyN7lRgj0PHp7nkdU0a90iVEu4tqyZMcinKyAHGQf6HB5GRzX0tc2gYFCMgis6XRLe6tZrS5gWW1mXa8ZHB/wAPUHsa3jXktznlh4vY a8U0ivWNb ETvMZdEuVRGbJhuScKOejAE46DBB teear4f1bRXK6jp89uAwXey5QkjIAYcE49D2PpXTGcZbM5pU5R3RkkU0ipSKaRVWIIyKaRUhFNIpDIiKaRUpFNIpDuREU0ipSKYRSKIiKaRUpFMIpDIiKaRUpFMIqRkgFOAoAp4FUIAKeBSAU8CmSAFPAoApwFUIAKcBQBTwKZIgFOApQKcBTEJitzSrV/7LjvBHuRLpWkOR8qkFQefcqOPWsR Fx68V6X4I0pNU0WfTpSiC4iZFZk3bWPRsdyDg/UVy4iWqideGjo5GbIAwqKBVjl38ZqnHduE8udHjmjJSRHXaysOCCD0Oe1BugOc1zHUbwvMjrT45d7DFYEd1vYAHmt/To8kE0AXvId/LK8DPzcV2miyPIBGMYQDNYtnbh12kcEfStfT0NheLuZikrcfL049h7d/X6CgDQmjaa m3RhRFtRSGzuGA2fbliO/StW1ULAAKa0So7yE5D8/kP/rVPHjaMDigCJysTs7MFQDcxPAArA0GMyXNxqMilVlkJVACxBZvYdOev41Z8RXbkQaXbHNxdH5tp5WMde/GTx6Ebq07G2 x2/kBQFTAVg2SwwOTwMHORjngD1wACzjJORQFA7U1JY5GkVJFZo22uFOSpwDg hwQfoRT6ACqep6fa6np9xaXcCTQyxlWRxwfT8jggjkEZFXKQ9OmaAPl3XtHm0HXLzTJzue3k2huBvU8q2ATjKkHGeM1mEV3/wAWrKO28amZCxa6to5nDHgEZTj2wg/HNcGRXpQfNFM8ya5ZNERFNIqUimkU7CIiKaRUpFMIpDIiKaRUpFMIqRoiIppFSkUwikUREU3FSEU3FIY8CngUgFOApiFAp4FAFOAqiWKBTgKAKeBTJACngUAU4CmIAKcBSgU4CqFcjcfMi46nNew BIxCtuMc4ryFQWvIl n6mvZ/CC WkeBnpmvPru82ehQVqaOG IGlNofjO8VZd0d4ftkeWyRvY7geBj5g2OvGOc5rmTK5HWve/Gngq28W6eJEKQapCn7i4I4I67Hx1Xk 6k5HcHwArJFI8U0bxyoxV0dSrKw4IIPQg1kbFqzmKTgsa7zRsOqnNeeIOeK7HQ7h41UE8UAei6ei4FbptRcWMsKsqSMhCOQTtbHB4IPHsR9RXK6fc8KQcV0tlc5wCaANOJGMGyT7yng tLJLHaWkk8zbYokLu2M4AGSeKcxdoGMRXzNp27ume2fasTUbaXXb46W29NMt2VrslMGduGSNG7AdWI/2QDndgAq6CJ9W1afW3EiQsSsOccoMgLg5x1ycfxZ9xXU01ESKNY41VEUBVVRgADoAKdQAUxI1RpGBYl23HLEgHAHAPQcdBxnJ6k0 igApM5bHoPSkdgilj0qO2LNGWYgszEnHQUAeTfGayjTUdKvgzebNFJCwJ UBCCMe/wC8P6V5cRXsXxls5JNO0q9BXyoZZImBPJLgEY9v3Z/SvICK9ChrTR51fSoyIimkVKRTCK0MrkZFMIqUimEUhkRFNIqUimEUiiIimEVKRTCKkpERFNIqQim4pDHAU8CkAp4FNCY4CnAUgFPApkigU8CkAp4FUSKBTwKQCngUxMAKcBQBTwKokS3XdqUQ n869q8JIdqccGvG9PXzNYiAH3eD/n8a9t8LRYSMAdOK82r8bPUo/wANHbL90fSvn74m6d/Znju7ZViSO8RLlFj7ZG1ieOpZWP419BV5L8a7Jdmk6gixBkZ4JGx87A4ZBnHIG1 /G73NZmh5pb8yL9a6vTFwoxXJWh/eL9a67TGBReaAOrsWKgV0FpNjHNc1aPwK2Ld RQB1dnOSQPWprGS0ktlltCoilZjgLs YsSwK8Ybdu3AjOc55FZlok88aLBP5LiRGLbQ2VDAsvPqoK57ZzW7QAUUUUAFFFHSgDB1zVxa3kFmjDzHBYjPIHQf1/KtTTm3WSE15tf6iNQ8aXjrLvjhcQJxjbt4Yf99bq9F0ok2CZoA5P4s201x4OSSNNyQXaSSHIG1cMuffllHHrXh5FfQ3j 2lu/A2qRwpvcIshGQPlR1Zjz6AE18 EV3YZ3gefilaZCRTSKlIphFdBzkRFNIqUimEVJSIiKYRUpFMIpMoiIphFSkUwipGREU2pCKYRSKHgU8CmgU8UxMcBTwKaBUgFNEigU8CkAp4FUSxQKeBSAU8CqJFAp4FIBTuAMk4A6mmIsaDH5mrliM4OBj8q908Lw7Y1PoK8W8JRGS6Ln7xbrXuvh2LZb5x2ryZO7bPYirJI3a8x MPkyaGvmsyvFKhiA/ibkYPH91m/KvTq8s K/77TcY3/veABn FsU4x5nYU5cqueTWjfOv1FdTpcgyQOgY1yNs3Q10mmOBK4BPXP5ipKOxtX4FbNs3SuftGyBW5aHOKAOt0c5YfStqubtcJbNL5jxeUNxkWQIIwflZzu UhQS2CCPlFbxlf7YkKxhkMbM77x8hyAox15 bn/Z96AJqKKKACo522QsfapK5zx5dw2fgjV5J32I1q8YOCfmcbFHHqzAUAeT F79r 8ubyYAS3E7SMFGAGY7jj25r2bQpC1mFPUV4P4KlJmaPjCsGz9f8A9Ve4eHDuhPPQc0AXtctpbzw/qVrAm aa1ljjXIGWKEAZPHU180kV9S18yX9nJp oXNnKVaS3laJyh4JUkHHtxXZhHujixa2ZSIphFSkU0ius4yIimEVIRTSKkoiIphFSEUwikUiMioyKlIphqRoiIplSkUwipKQ4U8U0VIKYhwFPFNFPFUiRwFSAU0CniqRLHAU8CmgVIBTJFAps5C27k mPz4qQCors4gxj7zAf1/pSqO0GyqavNI6fwXbZmicg4zmvctJTbaDjFeS DLbYsQIr2CxXbbLXlHrlgnAJ9K8g I7b7609t/8A7LXrszbYXPtXivjqVpNeVSxKrECFzwCScn9B VdGGV6iOfFO1JnnFselb msfPP4fyrEP/H3N/10b dbGnAi4HuoIrBqzsbp3VzsbI8Ct y5IFc9ZdBXQ2XUUhnYaKME/wC7WrFDHAhSKNI1LM5CKACzElj9SSSfUmsvRjnP 7WvQAUUUUAFcb8UJUXwPeQE/vLjbHEP7zZDY9uFPWuyrhfin/yL1r/19r/6A9aUlzTSZnWlywbR5D4LkYamyg/KY8ke4I/xNe6eGX/d47mvnzwu3l61bbzsIJUhuOcEY/Ove/DDjCDvWZodZXz14ys5LLxhqsUhUs1w0o2njD/OPxwwz719C14l8T7P7N4ykm8zd9qgjlxjG3A2Y9/uZ/GunCv32jlxa9xM4gimkVIRTCK7zz0REUwipSKYRUlERFMIqU1GallIjNRkVKajNJlIjNMNSGmVIxwqQUwU8U0DHiniminiqJY8U8U0U8U0QPFPFNFPFUhDgKiuFLywp2Y8/pUwpn37 BMdOc/5 lZYh2ps1wyvVR6X4WT5UGMYxXqVmNtqn0rzfwvHxGO5r0yJNkSr6CvNPUGXR220h9q8L8UO0niO6yxIUqFyegwOn45r3G/OLOQ 1eA6zMRqd/NIWbbK5POTgE8fkK68Gvfb8jjxr9xLzOUR/NleTGNzFsema3rBf30Z/wBgf1rBgGAK6PT1zchcY2qB9e/9a5G76nWlbQ6eyHArobIdKxrKPCit6yXkUDN7TdQitb2O1dJS80TOpRdw4eNcHHvIvsBkkjFbsVx5kzxMjq6MR9xtpAwQQxAB4YdO RztOOas4YpfE9iksaOosp3AYAjKy25B oIBHuK6iKLy44w7tLIibTK4G5umScADnGeAB7UASUUUUAFcN8Uh/wAU9bf9fS/ gPXc1xXxOieTwzCyIzBLpWcgZCjawyfQZIH4itaH8RGOI/hSPC7EeV4ii8zCgXSsSTwAWBz Ve7 HWxKg9K8Cv1ZNTlyMBgCvuMY/oa940JtsoYetTUVptF0neCfkdvXlPxdtI0v9MvAW8yWJ4mGeMIQRj3 c/pXqoOVB9RXn3xatI30WwvCW8yK4MSgHgh1JOff5B tXh3aojPEq9NnkJFRkVKaYa9M8tERphqQ0w1JSIzUZqQ0w1LKRGajNSmozUlIjNMNPNNNSUKKkWmCnimhDxUi0wU8VRLHipBTBTxVIljxUgpgp4qkSx4otwH1ZBnOFH50oo0/H9tc o/kK58U/cOjCK9Q9a8KIDLHkdBxXotcJ4Ui 6x5zXd1556RR1aURafISccV886pcM8F1OyjdISSBwAWP/169o8dX5tdHnAJBKbQV6gngH9a8N1ckWagfxOAefqf6V2Yf3ac5HFiPeqwgZ1uCxAUZPtXV6ZEWudxUgEDkj0rm7CLfKoPSursU2XA2jC9hXGdp01svArbs1wRWVZgECt20TpQBs6bZxvqMV6SwkigkiUA/KQ7ITn3 Qfma26z9MXhmGMD5Tz34NaFABRRRQAVznjuN5fB1 saM7YRsKMnAdST9AATXR1m IImm8P6jHGjPI1tIqqgJLEqcAAdfpV03aSZFRXg0fNGroVvopCRtZNo/A//AFxXsHhGQjS7Ed/Jj/8AQRXkmuIPKglycq 0fiM/0r0rwNctLpFm8hyQCoOOwJA/QCtMSrVWZYWV6SPV4jmJT7VyPxNs/tPg6SXzNv2WaOXGM7snZj2 /n8K6y2YNboR6VgeP4pJfBGpLGjOwVGIUZOBIpJ gAJ/CopO00aVVem/Q8FNMNSGozXqnkIjNMNPNMapZRGaYaeaYallIjNMNSGozSZSI2plPNMNSUOFPFMFPFCEyQU8UwU8VSJZIKeKYKeKpEskFPFMFPFUiWSCpNJQvrhPYY/kKjFWPD3OqSk5PzEfrXNi37iR04Ne 35HtHhaPaEP6119cv4YjxGv0zXTudqMfQZrgPRPL/iPfbpY7ZSw3Pk hA/ uRXlusNl4EDepK5 mD/Ou28bXHneIGUPlUQcZ6Ekn8DjH6Vwmosr6iADkqgB vJ/rXc1y4b1OBe9ivQu6TFk5xXU2sXQ1i6RD 7HFdLbR9K4TvNWxGMV0Nn2rCtV24rcs 1AHUWU2 JU24KjrVqs/Tj8x laFABRRRQAU1xlDTqQ/dNAHzTrEEgsrmJlKSR/eVwQRtOSCPXg10nw vWbTVikI2xysq8duD/MmqXiFQ3iDVFYAqbqUEHv85rJ8GXktpqJt3JAD8r6Hof5fpXZi1fll3OLBu3NDsfRthzaIexqr4k/5FbV/wDrym/9ANSaRKs2noy9MVYvbSO/sLmzlLCO4iaJip5AYEHHvzXJF2aZ2SV00fNJqM1IajNeweIhhqM1IajNSy0MNRmpDUZqWUhhqM1IajNJlIjNNpxptSyhRTxUYqQUIRIKetRipBVEskFPFRiniqRJKKeKjFPFUiWSirnhtN2pS/7/APWqQrT8HR5mJ9xXJi3okdeDWrZ7Z4ZTEIPoK3LltttIfasrw8m21z6iresTGHTpCCQSOoriO88N1ycXGu3ki5x5m3n24/pXLTFZdSlKnI3AfiAAa2pZWnnklYAM7FiB0yTmsazxPelwDhnLDP1rvxXu04xPPwnvVJSOs0uHCL610NtHwKzNNi QVvQR8CuA9As26YxWva9qz4VrRgGMUAblhNHHKiPIqtJlUDHBY4zgepwCfoDWpWLaSmKRCI3kywXauMjJxnkjgZye Bxk8VtUAFFFFABRRRQB4d43jSLxhqCoiqNyNhRjkopJ/Ekn8a4qyf7L4kbYTgSBjk uCf516B8RbX7N4skk37vtESS4xjbj5Me/3M/jXn18Gj1S3lyMFcAfTJ/qK76y5qEX2sefRfLiJLvc h/Ck/m2GPUAiugrifAl0JLRFz24rtq4D0D5mureWzupradNk0LtHIuQcMDgjI461XatbxN/yNOr/wDX7N/6GayDXsJ3VzxWrOww0xqeajNJjQw0w081GallIYaYaeaYaTKRGaYae1MqShRTxUYp4oQMkFSCoxTxVEskFSCohUgpokkFPFRg08GqRLHOxWJyDghSRXR DLckBvVq53AZSp6EYNaXh RrfUUX7S0MCnJ3SkD9TXLiot2aOvCTSume/aKpFrnHGAKy/HF0LfQLj95sYxkKc45xxj3qbS/EegpYqrazpysuAwa5QEE9M81xPxP1G3vm0p7DUUmgZZN4t5gyP93G7HBx2rmpxcppHVVmowcjz STy4XkxnapOPXFVNFj3TjjoKkvWK2cm04JwPwJwat HoOd OtdGMfvJHNgo 62djp8WFBxW3DHxVGxj UcVsRR4ArjO0fGtXIhioUWrMYxQBci5XGSM8ZBIP5jpW3BIZreOUxvEXUMY3xuXI6HBIyPYkVhRnFatg42NFtIK/OMIQMMT36E5BzjkZGeoyAXKKKKACiiigDyX4pW8qa9a3BXEUlvsVsjkqxJGPoy/nXmeqqv jyk4KybfbB//VXrnxZjfbpcoRjGDKrNjgE7cDPqcH8jXls8SzxFGAORwSM4PrXpQXPQseZUl7PEcx6P4DvdltEucHAr1RWDIGHQjNeAeGvEKeHz  sher/dZ9o nQ10 ofFie5tWhg0a2Xf8sguZDMjIQQRtAXr9fwrk r1Ox2fWaXcwPiL/wAj1qX/AGy/9FJXKGnE0wmvQiuWKR5snzSb7jTUZp5NRmgENNMNONMNSUhhphpxphqSkMNMNONNNSUAp4qMU8UASiniogaeDVIklBp4NRg08GqJZIDUgNRA08GmIlBp4NRA08GqJZKDTwaiBpwNMkgv3/dxpkgs2ceoH RXS H7ciJeK5 SFZWRiTlOlb mavBaLtlifA6FMHP8q4sRSnKd0tDvw9WnGFm9TtrOPAHFasS8VzVn4m0ooGkmeI/3WjJP6ZrYtNf0i4QsmoQKFO0 Y3lnOM9Gxkc9a5nTmt0dSqQezNVVqVRiq1tfWd05S3u4JmAyVjkDED14NWxUNW3LTvsQX p22k2Zu7rd5asBtTG5snoASMnv9Aah0vx/pN5qdtZRR3UXnuI1MkYxk8AcMTycD8fxrz/xZrQ1XU9kJzb22UQ5BDHPLAjscDHsM96wDgggjIPUV308LFwvLc8 pi5Kdo7H0nRWV4c1lNe0K2vlK Yy7ZlH8Mg 8MZOPUZ5wRVi51jTLKbybvUbSCXGdks6q2PoTXE4tOx3KSauXaK52fx14at5mifVYyy8Exxu6/gygg/gaxp/iroyJJ5FpeyyAHYGVVVj253Egfh FUqU3siXWprdk/xOtXn8KCZCoFvOkj57g5Xj8WH614yTXZ JfiJca/pb6emnxW0EuPMLSGRjhgRg4AHT0NcUTXoYeMoQtI87ETjOd4iE0wmlJphNamIhNMJpSaaTSYxpNMJpSaYTUlCE1GTTiaYTUlIaaYacTUZNJlDTTTSmmk1IxAakBqIGng0DZKDTwaiBp4NMklBp4NRA08GqJZKDTwaiBp4NMRKDTwaiBp4NUSSA08GogacDTESg04GogacDTJJQacDUQNLmncRLmlzUWaXNO4EmaM1HmjNFwsSbjjGePSm5puaTNADiaaTSZppNK4xSaaTSE00mkMUmmE0E00mkMQmmk0E0wmpGBNMJpSaYTSKEJphNKTTCakpDSaYTTiaYTSKQ0mmE0pNNzUjQgNPBqMGnA0IbJgacDUYNOBpkkoNPBqIGng1SESg08GogacDTJZKDTwaiBpwNUSSg04GogaeDTESA04GowaUGncRKDS5qIGnZpisSZpc1HmjNAWJM0ZqPNGaBWH5ozTN1Jmgdh5NNJpuaQmkFhSaaTSE0hNK4wJppNBNMJpDFJphNBNNJpFCE00mgmmE0hoCaYTSk0wmpZQhNMJpSaYTSKQhNMpSabmpGIDTwaiBp4NAyQGng1EDTwaaJZKDTwaiBpwNUImBpwNRA04GmSSg08GogacDTFYlBpQajBpwNMRIDTgaiBpwNMRJmlzUeaXNMViTNGaZmjdRcLEmaM1HmjNFwH5ozTN1Jmi4WH5pCaZmkzQA4mmk0hNNJpDsOJppNITTSaQ7ATTSaCaYTSHYUmmE0E00mkUITTSaCaaTUjEJphNKTTCaRSEJpuaCabmpGIDTgajBpwNAyUGng1EDTgaYiUGng1EDTgaZNiUGng1EDTgaoRKDTgaiBpwNO4iUGlBqMGlBpisSg07NRZpc0XFYlzRmo80uadxWJM0ZpmaM0XAkzRmo80ZouA/NGaZmkzRcLD80mabmkzQFhxNNJppNITSHYcTTSaQmmk0h2FJppNITTSaVxgTTSaCaaTSGBNMJoJppNIpIQmmk0E0wmkMCabmgmm5qRjQaeDUQNOBpDJQaeDUQNOBqhEoNPBqIGnA0xEoNOBqIGnA0xWJQacDUQNOBpkkoNKDUWadmmIlzS5qIGlzTuBLmlzUWaXNArEmaXNR5ozTuFiTNGajzRmi4WH5ozTM0ZpXCw7NJmm5pM0XAdmkJpuabmi47DiaQmmk0hNK47Ck00mkJppNIdhSaaTSE00mkOwE00mgmmE0hik0wmgmmk1IwJphNBNNzSKsNBp4NRinCkMkBp4NRA04GmSSg04GoxThVCJAacDUYNOFMRIDTgajpQaYiQGnA1FTgaBWJM0uajzS0xEmaM0zNLmgB 6jNMzRmmA/NGabRQFh2aM0zNFADs0mabmjNIBc0maTNJmgBSaaTSE0hpDsKTTSaSkNIYE00mg000hgTTSaDTTSGBNMJoJpppFICabmg0ykM//9k=");
		//System.out.println(GetImageStr());
//		System.err.println(PCUtils.getProperties("system-config.properties").get("server.uploadBasePath"));
//		System.out.println(OrderCodeFactory.makeOrderCode());
//		testToMap();
//		try {
//			testRSA("");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/**
		 * 测试生成订单编号
		 */
//		System.out.println(OrderCodeFactory.makeOrderCode("2a573872-ec75-42ce-9954-0f16e14f99b3"));
		
		/**
		 * 测试汉语拼音
		 */
//		System.out.println(ChineseUtils.getPingYin("紫夜寒风"));
//		System.out.println(ChineseUtils.getHeadChar("紫夜寒风"));
//		System.out.println(ChineseUtils.getPinYinHeadChar("紫夜寒风"));
		
		/**
		 * 测试HttpClient访问URL
		 */
		
		/**
		 * 登录
		 */
		
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/login/deptLogin?dc=TEST&pw=111",null));
		
		/**
		 * 查询指定门店信息
		 */
		
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/user/showDpetInfo?di=c3092da4-7a24-4e6d-a6f9-4e653b921406","D2B5ED098ADE6DCD67A850612CE97701.jvm01"));
		
		/**
		 * 查询指定门店所有员工信息
		 */
		
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/user/showWorker?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&ui=2a810c71-0230-4d6f-b0bc-6365091f5bcf","B81F4CEAE04C1B6E4EB4A5DCFAA1C143"));

		/**
		 * 查询门店客户基本信息
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/customer/showCustomer?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&page=1","E8F44E44083158A0E7BFE5DF101FE6E4.jvm1"));

		/**
		 * 查询指定客户详细信息
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/customer/showCustomer?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&page=1&ci=3ddaeb14-335e-4735-891e-fb3a83a5a1a6","D2B5ED098ADE6DCD67A850612CE97701.jvm01"));

		/**
		 * 新增设计方案
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/design/addDesign?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&ds={assetBundleName: suit004,type: suit,DesignName: 我的设计,type_name: 单排四粒扣西服,suitBom:{},shirtBom:{},suitButton:{},tieBom:{},kouyanBom:{},collar:{workshopname:22,image:,image3:upload/备用图/,modelname:collar_003,name:戗驳领,style:collar,remark:,id:f781c425-260e-434a-bdc5-b4e861df97d0,type:西服领形,image1:json/suit/image/2aa747ea-11ec-4b02-b3da-c52f82707dbc.jpg,image2:upload/PC版缩略图/},buttonNum:{workshopname:d,image:,image3:upload/备用图/,modelname:buttonnum4,name:四粒扣,style:buttonNum,remark:,id:f897bbba-5d1e-4121-b9de-b048b6a42714,type:西服袖扣数目,image1:json/suit/image/9d59ea69-c6ca-44f9-926d-8930c381ccd7.jpg,image2:upload/PC版缩略图/},placket:{workshopname:w,image:,image3:upload/备用图/,modelname:placket_007,name:单门襟四粒扣+直摆,style:placket,remark:,id:c150479e-aa89-460e-adcc-ea1c691f719a,type:西服门襟,image1:json/suit/image/db385ef2-43c2-41ed-ba89-e34f8e1f4a82.jpg,image2:upload/PC版缩略图/},back:{workshopname:后片2,image:,image3:upload/备用图/,modelname:back_003,name:单开叉,style:back,remark:,id:cad5a8c9-c316-4b1e-b267-1c93bb21f9ee,type:西服后片,image1:json/suit/image/60c84220-5009-48b7-a17f-911c960d56f5.jpg,image2:upload/PC版缩略图/},breastPocket:{workshopname:s,image:,image3:upload/备用图/,modelname:breastPocket_003,name:船形手巾袋,style:breastPocket,remark:,id:ead807a2-1518-4c86-8c34-3b399d71bbaf,type:西服胸袋,image1:json/suit/image/8405ef94-0371-4b4f-9df9-fdecd5cb7138.jpg,image2:upload/PC版缩略图/},buff:{workshopname:袖口2,image:,image3:upload/备用图/,modelname:buff_001,name:西服普通袖子,style:buff,remark:,id:9c6806cd-dde0-4dc4-b6f7-9af237dc4ce2,type:西服袖子,image1:json/suit/image/1983981e-36e4-4894-bf07-69daf3ea459f.jpg,image2:upload/PC版缩略图/},pocket:{workshopname:口袋6,image:,image3:upload/备用图/,modelname:pocket_006,name:一嵌线袋盖,style:pocket,remark:,id:ee9bd0ea-7b94-4c30-94d0-bbd0884ee39b,type:西服口袋,image1:json/suit/image/e512370b-ba81-4a8f-9fe7-bebdbd9a4dd5.jpg,image2:upload/PC版缩略图/},buttonEye:{workshopname:无,image:,image3:upload/备用图/,modelname:buttonEye_buttonnum4,name:袖口四粒扣扣眼,style:buttonEye,remark:,id:f9805845-6d99-443e-aaf3-b958c7a05c2a,type:西服扣眼,image1:json/suit/image/,image2:upload/PC版缩略图/}}","6488D6A324A5604F779924C95D6D8A84"));
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/design/addDesign?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&ds=assetBundleName:suit004","38C5B02DE2630B428876F25B1FF6F786"));
		
		/**
		 * 查询所有设计方案信息
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/design/showDesign?di=c3092da4-7a24-4e6d-a6f9-4e653b921406","FC252E50E4F354B5554DCC3F63AA12ED"));

		
		/**
		 * 查询设计方案信息详情
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/design/showDesign?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&type=suit&id=1","3BC39D017CA0C195ACC27FE0EA570F98"));
		
		/**
		 * 查询客户量体信息
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/customer/showCustomerMeasureData?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&ci=1263a995-1111-4f8d-96e1-975646902656&style=down","00D683D531C04775B3623F2105F009F5"));

		
		/**
		 * 加入购物车
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/shoppingCart/addShoppingCart?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&designid=66bb3f41-7005-4e07-98fd-9df6ca102cb1","7CB3B5AC58C8262C50E9CF319200A68F"));
	
		/**
		 * 查询购物车基本信息
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/shoppingCart/showShoppingCart?di=c3092da4-7a24-4e6d-a6f9-4e653b921406","E8F44E44083158A0E7BFE5DF101FE6E4.jvm1"));
	
		/**
		 * 查询指定购物车详细信息
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/shoppingCart/showShoppingCart?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&scid=3fc1d0ec-1dcb-479b-9fa1-09745dc26f82","4DF8DF6110D0EA69D2F9D24E80F94A10"));
	
		/**
		 * 删除指定购物车
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/shoppingCart/deleteShoppingCart?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&scid=e6c844f3-519f-4906-b196-28809a8dbce3","4DF8DF6110D0EA69D2F9D24E80F94A10"));
		
		
		/**
		 * 测试查询工艺/特殊工艺
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/order/showSpecialCraft?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&type=shirt","47DFC3AE8499F595A35868F45DF57A6D"));

		/**
		 * 测试查询面料信息
		 */
//		System.out.println(testHttpClient("http://localhost:8080/zyrsback/bomInfo/showBomInfoByID?di=c3092da4-7a24-4e6d-a6f9-4e653b921406&bi=54fb1562-7b03-4de2-af8e-8cfe94495689&styleid=shirt","F70C56687D58872F1732F6E9DECF42AB"));

		/**
		 * 测试查询订单信息
		 */
		System.out.println(testHttpClient("http://localhost:8080/zyrsback/order/showOrder?di=98538517-BC64-429E-83FF-B07A99A00FA8","87481C742D849B8D6DD869789017AA09.jvm1"));

	}

}
