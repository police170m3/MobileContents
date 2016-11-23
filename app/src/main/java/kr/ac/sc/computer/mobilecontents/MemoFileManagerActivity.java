package kr.ac.sc.computer.mobilecontents;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by MSI on 2016-11-16.
 */
public class MemoFileManagerActivity extends Activity {
    ObjectFileManager mObjFileMgr = new ObjectFileManager(this);
    EditText mMemoTitleEdit = null;
    EditText mMemoEdit = null;
    //TextFileManager mTextFileMgr = new TextFileManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memofilemanager_activity);

        mMemoTitleEdit = (EditText) findViewById(R.id.memo_title_edit);
        mMemoEdit = (EditText) findViewById(R.id.memo_edit);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.load_btn:
                HashMap<String, String> memoData = mObjFileMgr.load();

                if (memoData != null) {
                    mMemoTitleEdit.setText(memoData.get("title"));
                    mMemoEdit.setText(memoData.get("memo"));
                }
                /*String memoData = mTextFileMgr.load();
                mMemoEdit.setText(memoData);*/

                Toast.makeText(this, "불러오기 완료", Toast.LENGTH_LONG).show();
                break;

            case R.id.save_btn:
                String memoTitleStr = mMemoTitleEdit.getText().toString();
                String memoStr = mMemoEdit.getText().toString();

                HashMap<String, String> memoData2 = new HashMap<String, String>();

                memoData2.put("title", memoTitleStr);
                memoData2.put("memo", memoStr);

                mObjFileMgr.save(memoData2);

                mMemoEdit.setText("");
                mMemoTitleEdit.setText("");

                /*String memoData2 = mMemoEdit.getText().toString();
                mTextFileMgr.save(memoData2);
                mMemoEdit.setText("");*/

                Toast.makeText(this, "저장 완료", Toast.LENGTH_LONG).show();
                break;

            case R.id.delete_btn:
                mObjFileMgr.delete();

                mMemoEdit.setText("");
                mMemoTitleEdit.setText("");

                /*mTextFileMgr.delete();
                mMemoEdit.setText("");*/

                Toast.makeText(this, "삭제 완료", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
