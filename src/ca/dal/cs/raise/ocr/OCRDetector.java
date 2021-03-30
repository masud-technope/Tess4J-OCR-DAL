package ca.dal.cs.raise.ocr;

import java.io.File;
import config.StaticData;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class OCRDetector {

	String imageFilePath;

	public OCRDetector(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	protected void detectOCR() {
		File myFile = new File(this.imageFilePath);
		ITesseract detector = new Tesseract();
		detector.setDatapath(StaticData.MODEL_DATA_PATH);
		try {
			String content = detector.doOCR(myFile);
			System.out.println(content);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String imageFile = "./data/SRI-step1.png";
		new OCRDetector(imageFile).detectOCR();
	}
}
