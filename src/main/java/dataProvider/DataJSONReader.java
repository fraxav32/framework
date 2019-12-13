package dataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;


public class DataJSONReader {
	Logger logger = Logger.getLogger(DataJSONReader.class);;
	List<Object> data = new ArrayList<>();
	
	
	public  List<Object> readJsonDataList(String filePath, Class classToMap, String nodeToRead) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = null;
		Object nodeObject = null;
		try {
			rootNode = mapper.readTree(new File(filePath));
		} catch (JsonProcessingException e) {
			logger.error("IOException ", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException ", e);
			e.printStackTrace();
		}
		
		JsonNode jsonNode = rootNode.get(nodeToRead);
		try {
			if(jsonNode.isArray()) {
				for(JsonNode tc : jsonNode ) {
					nodeObject = mapper.treeToValue(tc, classToMap);
					data.add((Object) nodeObject);
				}
			}

		} catch (JsonParseException e) {
			logger.error("JsonParseException ", e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		}catch (Exception e) {
			logger.error("Exception", e);
			e.printStackTrace();
		}
	return data;
	}
	
	
	public Object readJsonNode(String filePath, Object classToMap, String nodeToRead) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = null;
		Object nodeObject = null;
		try {
			rootNode = mapper.readTree(new File(filePath));
		} catch (JsonProcessingException e) {
			logger.error("IOException ", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException ", e);
			e.printStackTrace();
		}

		JsonNode jsonNode = rootNode.get(nodeToRead);
		try {
			System.out.println(classToMap.getClass());
			nodeObject = mapper.treeToValue(jsonNode, classToMap.getClass());

		} catch (JsonParseException e) {
			logger.error("JsonParseException ", e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		}
		return nodeObject;
	}

	public Object readJsonObject(String filePath, Object classToMap) {
		BufferedReader br = null;
		Object object = null;
		Gson gsonObj = new Gson();
		try {
			br = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException iOException) {
			logger.error("iOException", iOException);
			iOException.printStackTrace();
		}
		try {

			object = gsonObj.fromJson(br, classToMap.getClass());

		} catch (Exception e) {
			logger.error("", e);
			e.printStackTrace();
		}
		return object;
	}
}
