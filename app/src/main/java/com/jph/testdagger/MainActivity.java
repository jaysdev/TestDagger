package com.jph.testdagger;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jph.testdagger.di.component.DaggerMainComponent;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Context mContext;
    @Inject
    MainPresenter mMainPresenter;

    @Bind(R.id.main_txt)
    TextView mAuthorNameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder()
                .applicationComponent(((MyApplication) getApplication()).getApplicationComponent())
//                .mainModule(new MainModule(this))
                .build()
                .inject(this);
        ButterKnife.bind(this);

//        mMainPresenter = new MainPresenter(this);
//        Log.i(TAG,""+mAuthor);
    }

    @OnClick(R.id.main_btn)
    public void onClickBtn(View v) {
        mMainPresenter.loadName();
    }

    @Override
    public void setAuthorNameText(String name) {
        mAuthorNameTxt.setText(name);
    }
}
