package kr.ac.sc.computer.mobilecontents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by MSI on 2016-10-12.
 */

public class ActivityA extends Activity{
    private String mSendPicUrl = "/data/pics";
    public static final int REQUEST_CODE_PIC_FILE_URL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Button loadPicUrlBtn = (Button) findViewById(R.id.load_pic_url_btn);
        String loadUrlStr = "사진 불러오기 : " + mSendPicUrl;
        loadPicUrlBtn.setText(loadUrlStr);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.load_pic_url_btn:
                Intent intent = new Intent();
                intent.setClass(this, ActivityB.class);
                intent.putExtra("PIC_URL", mSendPicUrl);
                startActivityForResult(intent, REQUEST_CODE_PIC_FILE_URL);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_CODE_PIC_FILE_URL) {
            if (resultCode == RESULT_OK) {
                String picFileUrlStr = intent.getStringExtra("RESULT_PIC_FILE_URL");
                TextView picFileUrlTv = (TextView) findViewById(R.id.result_pic_file_url);
                picFileUrlTv.setText("선택된 사진 파일 경로 : " + picFileUrlStr);
            }
        }
    }
}
