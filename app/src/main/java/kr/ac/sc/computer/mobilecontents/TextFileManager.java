package kr.ac.sc.computer.mobilecontents;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by MSI on 2016-11-16.
 */

public class TextFileManager {
    private static final String FILE_NAME = "Memo.txt";
    Context mContext = null;

    public TextFileManager(Context _context) {
        mContext = _context;
    }

    public void save(String strData) {
        if (strData == null || strData.isEmpty() == true) {
            return;
        }

        FileOutputStream fosMemo = null;

        try {
            fosMemo = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fosMemo.write(strData.getBytes());
            fosMemo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  String load() {
        try {
            FileInputStream fisMemo = mContext.openFileInput(FILE_NAME);
            byte[] memoData = new byte[fisMemo.available()];
            while (fisMemo.read(memoData) != -1) {
            }
            fisMemo.close();
            return new String(memoData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void delete()
    {
        mContext.deleteFile(FILE_NAME);
    }
}
