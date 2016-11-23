package kr.ac.sc.computer.mobilecontents;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MSI on 2016-11-23.
 */
public class PrefActivity extends Activity{
    CheckBox mSoundChkbox  = null, idCheck2 = null;
    SharedPreferences mPref         = null, mPrefId = null;
    EditText editText = null;
    String id = "";

    // 공유 프레퍼런스 값이 변경되었을 때 호출되는 리스너 정의
    // ========================================================================
    SharedPreferences.OnSharedPreferenceChangeListener
            mPrefChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener()
    {
        @Override
        public void
        onSharedPreferenceChanged( SharedPreferences sharedPreferences,
                                   String key )
        {
            boolean isSoundOn = sharedPreferences.getBoolean( key, true );

            Toast.makeText( PrefActivity.this,
                    key + " 설정이 " + isSoundOn + "로 변경",
                    Toast.LENGTH_LONG ).show();
        }
    };
    // ========================================================================

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pref );

        mSoundChkbox = (CheckBox) findViewById( R.id.sound_on_off_chkbox );
        idCheck2 = (CheckBox) findViewById(R.id.checkBox2);
        editText = (EditText) findViewById(R.id.editText_id);

        // 1. 공유 프레퍼런스 객체를 얻어온다.
        // ====================================================================
        mPref = getSharedPreferences( "Setting", Context.MODE_PRIVATE );
        // ====================================================================

        // 2. 공유 프레퍼런스를 이용하여 사운드 on/off 설정 값을 얻어온다.
        // ====================================================================
        boolean isSoundOn = mPref.getBoolean( "SOUND_SET", true );
        // ====================================================================

        // 3. 공유 프레퍼런스 값이 변경되었을 때 호출되는 리스너 등록
        // ====================================================================
        mPref.registerOnSharedPreferenceChangeListener( mPrefChangeListener );
        // ====================================================================

        // 4. 현재 사운드 설정 값을 체크 박스에 반영한다.
        // ====================================================================
        mSoundChkbox.setChecked( isSoundOn );
        // ====================================================================
        mPrefId = getSharedPreferences( "ID_CHECK", Context.MODE_PRIVATE );
        boolean idCheck = mPref.getBoolean( "ID_CHECK", true );
        idCheck2.setChecked( idCheck );

        getPreferences();
        editText.setText(id);
    }

    @Override
    protected void onDestroy()
    {
        // 공유 프레퍼런스 값이 변경되었을 때 호출되는 리스너 등록 해제
        // ====================================================================
        mPref.unregisterOnSharedPreferenceChangeListener( mPrefChangeListener );
        // ====================================================================

        super.onDestroy();
    }

    public void onClick( View v )
    {
        // 1. 현재 체크 박스의 on/off 상태를 얻어온다.
        // ====================================================================
        boolean isSoundOn = mSoundChkbox.isChecked();
        // ====================================================================

        // 2. 공유 프레퍼런스에 사운드 설정 값을 저장한다.
        // ====================================================================
        SharedPreferences.Editor prefEditor = mPref.edit();
        prefEditor.putBoolean( "SOUND_SET", isSoundOn );
        prefEditor.apply();
        // ====================================================================
    }
    public void onClick2(View v){
        boolean idCheckOn = idCheck.isChecked();
        SharedPreferences.Editor prefEditor = mPref.edit();
        prefEditor.putBoolean( "ID_CHECK", idCheckOn );
        prefEditor.apply();
    }

    private void getPreferences(){
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        id = pref.getString("id", "");
    }
}
