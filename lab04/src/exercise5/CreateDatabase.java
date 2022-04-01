package exercise5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class create a database in server-side
 *
 */

public class CreateDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//initialize the multilingual text
		String[] text = {"Good morning","Selamat pagi","صباح الخير", "좋은 아침",
				"Good night","Selamat malam","مساء الخير","안녕히 주무세요",
				"How are you?","Apa khabar?","كيف حالك؟","어떻게 지내세요?",
				"Thank you","Terima kasih","شكرا لك","감사합니다","Goodbye",
				"Selamat tinggal","مع السلامة","안녕","What’s up?","Ada apa?",
				"ما أخبارك؟","뭐야?"};
		
		//create a txt file name as database
		String database = "database.txt";
		
		//save all text in database.txt
		try {
			PrintWriter outDatabase = new PrintWriter(new FileWriter(database));
			for (int i = 0; i<text.length;i++) {
				outDatabase.write(text[i] +"\n");
				outDatabase.flush();
			}
			outDatabase.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		
	}

}
