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

public class ActivityB extends Activity {
    private String mResultPicFileUrl = "/data/pics/a.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String picUrl = bundle.getString("PIC_URL");

        TextView loadPicUrlTextView = (TextView) findViewById(R.id.received_pic_folder_url);
        String picUrlStr = "전달받은 사진 폴더 : "+picUrl;
        loadPicUrlTextView.setText(picUrlStr);

        Button resultPicFileUrlBtn = (Button) findViewById(R.id.send_pic_file_url_btn);
        String picFileUrlStr = "선택된 사진 경로 전달 \n" + mResultPicFileUrl;
        resultPicFileUrlBtn.setText(picFileUrlStr);
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("RESULT_PIC_FILE_URL", mResultPicFileUrl);

        setResult(RESULT_OK, intent);
        finish();
    }
}
