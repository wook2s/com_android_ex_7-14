package com.example.asb_ex_7_14;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목");
                dlg.setMessage("내용입니다");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "확인 누름", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });


        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] arr = new String[]{"1", "2", "3"};

                AlertDialog.Builder dlg2 = new AlertDialog.Builder(MainActivity.this);
                dlg2.setTitle("목록형제목");
                dlg2.setItems(arr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String str = String.valueOf(i + 1);
                        Toast.makeText(MainActivity.this, str + "을/를 누름", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg2.setNegativeButton("취소", null);
                dlg2.show();


            }
        });

        btn3 = (Button) findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] arr = new String[]{"1", "2", "3"};

                AlertDialog.Builder dlg3 = new AlertDialog.Builder(MainActivity.this);
                dlg3.setTitle("라디오버튼 형");
                dlg3.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String str = String.valueOf(i + 1);
                        Toast.makeText(MainActivity.this, str + "을/를 누름", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg3.setNegativeButton("취소", null);
                dlg3.show();
            }
        });

        btn4 = (Button) findViewById(R.id.btn4);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] arr = new String[]{"1", "2", "3"};
                final boolean[] arrChk = new boolean[]{false, false, false};

                final boolean[] chk = new boolean[]{false, false, false};

                AlertDialog.Builder dlg4 = new AlertDialog.Builder(MainActivity.this);
                dlg4.setTitle("여러개 선택가능 라디오버튼형");
                dlg4.setMultiChoiceItems(arr, arrChk, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                        String tmp = "";
                        chk[i] = b;

                        for (int idx = 0; idx < arr.length; idx++) {
                            if (chk[idx] == true) {
                                tmp += arr[idx];
                            }
                        }
                        if (tmp.equals("")) {
                            Toast.makeText(MainActivity.this, "선택사항 없음", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, tmp + "가 추가됨", Toast.LENGTH_SHORT).show();
                        }
                        //getData(tmp);
                        data = tmp;
                    }
                });
                dlg4.setNegativeButton("닫기", null);
                dlg4.setPositiveButton("제출", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, data + " 선택 후 제출버튼 누름", Toast.LENGTH_SHORT).show();
                        data = "";
                    }
                });
                dlg4.show();


            }
        });


    }

    String data = "";

    public void getData(String str) {
        Toast.makeText(MainActivity.this, str + "이 넘어왔습니다 ", Toast.LENGTH_SHORT).show();
    }
}