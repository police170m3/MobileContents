package kr.ac.sc.computer.mobilecontents;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Created by MSI on 2016-11-23.
 */

public class ObjectFileManager {
    private static final String MEMO_FILE_FULL_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "Memo.obj";

    /*private static final String FILE_NAME = "Memo.obj";*/
    Context mContext = null;

    public ObjectFileManager(Context _context) {
        mContext = _context;
    }

    public void save(HashMap<String, String> objData) {
        if (objData == null || objData.isEmpty() == true) {
            return;
        }

        ObjectOutputStream oos = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(MEMO_FILE_FULL_PATH);
            //fos = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(objData);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, String> load() {
        try {
            FileInputStream fis = new FileInputStream(MEMO_FILE_FULL_PATH);
            //FileInputStream fis = mContext.openFileInput(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<String, String> memoData = null;
            memoData = (HashMap<String, String>)ois.readObject();

            ois.close();

            return memoData;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete() {
        //mContext.deleteFile(FILE_NAME);
        File deleteFile = new File(MEMO_FILE_FULL_PATH);
        deleteFile.delete();
    }
}