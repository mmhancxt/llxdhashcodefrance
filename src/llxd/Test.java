package llxd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		DataCenter dc = new DataCenter(16, 100);
		ReadData(dc);
	}

	public static void ReadData(DataCenter dc) {
		BufferedReader br = null;

		try {
			String line;

			br = new BufferedReader(new FileReader("dc.in"));

			br.readLine();
			int R, S, U, P, M;
			R = 16;
			S = 100;
			U = 80;
			P = 45;
			M = 625;

			int i = 1;
			ArrayList<Server> list =  new ArrayList<Server>();
			while ((line = br.readLine()) != null) {
				String strs[] = line.split(" ");
				int x, y;
				x = Integer.parseInt(strs[0]);
				y = Integer.parseInt(strs[1]);
				if (i >= 1 && i <= 80) {
					dc.dc[x][y] = -1;
				} else {
					Server s = new Server(i - 80, x, y);
					list.add(s);
				}
				i++;
			}
			dc.setServerList(list);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
