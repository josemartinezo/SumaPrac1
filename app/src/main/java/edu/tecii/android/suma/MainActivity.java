package edu.tecii.android.suma;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.suma)
    EditText suma;
    @Bind(R.id.btnSumbit)
    Button btnSumbit;
    @Bind(R.id.txtSuma)
    TextView txtSuma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSumbit)
    public void handleClickSubmit() {
        hideKeyboard();
        //handleTipChange(TIP_STEP_CHANGE);
        String strInputNum = suma.getText().toString().trim();
        if (!strInputNum.isEmpty()) {
            int numero = Integer.parseInt(strInputNum);
            double SumaTo = numero*(numero+1)/2;

            String strSuma = String.format("La suma de los "+ numero+" numeros enteros es: "+ SumaTo);
            txtSuma.setVisibility(View.VISIBLE);
            txtSuma.setText(strSuma);
        }
    }


    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        } catch (NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }

}
