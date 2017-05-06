package id.arieridwan.coffeshop;

import android.content.pm.ProviderInfo;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mTextNama;
    private Spinner mMenu;
    private RadioGroup mFlavor;
    private RadioButton mFlavorChocolate;
    private RadioButton mFlavorMoccha;
    private Button mMinus;
    private TextView mQuantity;
    private Button mPlus;
    private TextView mPrice;
    private Button mReset;
    private Button mOrder;

    private int qty = 0;
    private int price = 0;

    private List<String> categories = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init view
        initView();
        initEvent();
    }

    private void initView() {
        mTextNama = (EditText) findViewById(R.id.mTextNama);
        mMenu = (Spinner) findViewById(R.id.mMenu);
        mFlavor = (RadioGroup) findViewById(R.id.mFlavor);
        mFlavorChocolate = (RadioButton) findViewById(R.id.mFlavorChocolate);
        mFlavorMoccha = (RadioButton) findViewById(R.id.mFlavorMoccha);
        mMinus = (Button) findViewById(R.id.mMinus);
        mQuantity = (TextView) findViewById(R.id.mQuantity);
        mPlus = (Button) findViewById(R.id.mPlus);
        mPrice = (TextView) findViewById(R.id.mPrice);
        mReset = (Button) findViewById(R.id.mReset);
        mOrder = (Button) findViewById(R.id.mOrder);
    }

    private void initEvent() {

        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty++;
                mQuantity.setText(String.valueOf(qty));
                price = 5 * qty;
                mPrice.setText("Price: $" + price);
            }
        });

        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qty>0){
                    qty--;
                    mQuantity.setText(String.valueOf(qty));
                    price = 5 * qty;
                    mPrice.setText("Price: $" + price);
                }
            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = 0;
                price = 0;
                mQuantity.setText(String.valueOf(qty));
                mPrice.setText("Price $" + price);
            }
        });

        //spiner
        categories.add("Coffe");
        categories.add("Tea");
        categories.add("Milk");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMenu.setAdapter(dataAdapter);
        mMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, adapterView.getSelectedItem()+" selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mFlavor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.mFlavorChocolate:
                        Toast.makeText(MainActivity.this, "Chocolate flavor", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.mFlavorMoccha:
                        Toast.makeText(MainActivity.this, "Moccha flavor", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


}
