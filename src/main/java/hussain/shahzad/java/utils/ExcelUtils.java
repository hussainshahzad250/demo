package hussain.shahzad.java.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;

public class ExcelUtils {

	public static File convertToFile(MultipartFile excellFile) throws Exception {
		File convFile = new File(excellFile.getOriginalFilename());
		FileOutputStream fos = null;
		try {
			convFile.createNewFile();
			fos = new FileOutputStream(convFile);
			fos.write(excellFile.getBytes());
		} finally {
			if(fos!=null) {
				fos.close();
			}
		}
		return convFile;
	}
	
	public static <T> List<T> toList(MultipartFile excellFile, Class<T> t) {
		PoijiOptions options = PoijiOptionsBuilder.settings(1).build();
		try {
			List<T> list = Poiji.fromExcel(convertToFile(excellFile).getAbsoluteFile(),
					t, options);
			return list;
		} catch (Exception e) {
		}
		return null;
	}
}
