package com.example.udall.molarmass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//************************************************************************//
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button buttont = (Button) findViewById(R.id.buttont);
        Button CLS = (Button) findViewById(R.id.CLS);

//****Clear Text**************************************************************//
        CLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
//***************Get INPUT***************************************************//
        buttont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> num = new ArrayList<>();
                ArrayList<Double> e_value = new ArrayList<>();
                String output = "", bracket = "", main = "";
                double total = 0.0;
                int countx =0,count = 0,count_lower=0;
                String editvalue = editText.getText().toString();

                char[] in = editvalue.toCharArray();

                for (int i=0; i< in.length;i++ )
                {
                    if(in[i]=='(')
                    {
                        countx = 1;
                        break;
                    }

                    if (Character.isLowerCase(in[i])){
                        count_lower+=1;
                    }
                }

                if (count_lower== in.length){
                    count =1;
                }
//**************If it contains Brackets**********************************************************//
                if (countx==1) {
                    String pattern = "\\((.*?)\\)+\\d";
                    Matcher m = Pattern.compile(pattern).matcher(editvalue);

                    while (m.find()) {
                        bracket = m.group(0);
                    }
                    Pattern pt = Pattern.compile(pattern);
                    String[] parts = pt.split(editvalue);

                    for (int i = 0; i < parts.length; i++) {
                        main = main + parts[i];
                    }

                    bracket = bracket.replaceAll("[()]", "");
                    char[] br = bracket.toCharArray();

                    int mult = Character.getNumericValue(br[br.length - 1]);
                    bracket = bracket.substring(0, bracket.length() - 1);

                    String[] bracket_array = bracket.split("(?=\\p{Upper})");

                    for (int i = 0;i < bracket_array.length;i++) {
                        int length = bracket_array[i].length();

                        if (length == 1){
                            bracket_array[i] = bracket_array[i] + mult;
                        }

                        if (length > 1){
                            String let = bracket_array[i];
                            char[] letters = let.toCharArray();
                            String number = "";

                            for (int x=0; x< letters.length;x++ ) {
                                if (Character.isDigit(letters[x])) {
                                    number = number+letters[x];
                                }
                            }
                            number=String.valueOf(Integer.parseInt(number)*mult);
                            bracket_array[i]="";

                            for (int x = 0;x<letters.length;x++)
                            {
                                if (Character.isDigit(letters[x]))
                                {
                                    bracket_array[i]=bracket_array[i]+number;
                                    break;
                                }
                                else
                                {
                                    bracket_array[i]=bracket_array[i]+letters[x];
                                }
                            }
                        }

                    }
                    bracket = "";
                    for (int i = 0;i < bracket_array.length;i++)
                    {
                        bracket= bracket+bracket_array[i];
                    }
                    editvalue = main + bracket;

                }
//***********************Calculation*************************************************//
                String[] arr = editvalue.split("(?=\\p{Upper})");

                for (int i=1; i< arr.length;i++ )
                {
                    String let = arr[i];
                    arr[i] = arr[i].replaceAll("[0-9]", "");
                    String number = "";
                    char[] letters = let.toCharArray();

                    for (int x=0; x< letters.length;x++ ) {
                        if (Character.isDigit(letters[x])) {
                            number = number+letters[x];
                        }
                    }

                    if (number.equals("")){
                        number ="1";
                    }
                    num.add(Integer.parseInt(number));

                }
//*******************Find the element value************************************************//
                for (int i=1; i< arr.length;i++ ) {
                    switch (arr[i]) {
                        case "H":
                            e_value.add(1.00795);
                            break;
                        case "He":
                            e_value.add(4.00260);
                            break;
                        case "Li":
                            e_value.add(6.9412);
                            break;
                        case "Be":
                            e_value.add(9.01218);
                            break;
                        case "B":
                            e_value.add(10.8117);
                            break;
                        case "C":
                            e_value.add(12.0108);
                            break;
                        case "N":
                            e_value.add(14.00674);
                            break;
                        case "O":
                            e_value.add(15.9994);
                            break;
                        case "F":
                            e_value.add(18.9984);
                            break;
                        case "Ne":
                            e_value.add(20.1797);
                            break;
                        case "Na":
                            e_value.add(22.9898);
                            break;
                        case "Mg":
                            e_value.add(24.3051);
                            break;
                        case "Al":
                            e_value.add(26.9815);
                            break;
                        case "Si":
                            e_value.add(28.0855);
                            break;
                        case "P":
                            e_value.add(30.9738);
                            break;
                        case "S":
                            e_value.add(32.0666);
                            break;
                        case "Cl":
                            e_value.add(35.4528);
                            break;
                        case "Ar":
                            e_value.add(39.948);
                            break;
                        case "K":
                            e_value.add(39.0983);
                            break;
                        case "Ca":
                            e_value.add(40.0784);
                            break;
                        case "Sc":
                            e_value.add(44.9559);
                            break;
                        case "Ti":
                            e_value.add(47.8761);
                            break;
                        case "V":
                            e_value.add(50.9415);
                            break;
                        case "Cr":
                            e_value.add(51.9962);
                            break;
                        case "Mn":
                            e_value.add(54.9380);
                            break;
                        case "Fe":
                            e_value.add(55.8452);
                            break;
                        case "Co":
                            e_value.add(58.9332);
                            break;
                        case "Ni":
                            e_value.add(58.6934);
                            break;
                        case "Cu":
                            e_value.add(63.5463);
                            break;
                        case "Zn":
                            e_value.add(65.392);
                            break;
                        case "Ga":
                            e_value.add(69.723);
                            break;
                        case "Ge":
                            e_value.add(72.612);
                            break;
                        case "As":
                            e_value.add(74.9216);
                            break;
                        case "Se":
                            e_value.add(78.963);
                            break;
                        case "Br":
                            e_value.add(79.90);
                            break;
                        case "Kr":
                            e_value.add(83.801);
                            break;
                        case "Rb":
                            e_value.add(85.4678);
                            break;
                        case "Sr":
                            e_value.add(87.621);
                            break;
                        case "Y":
                            e_value.add(88.9059);
                            break;
                        case "Zr":
                            e_value.add(91.2242);
                            break;
                        case "Nb":
                            e_value.add(92.9064);
                            break;
                        case "Mo":
                            e_value.add(95.941);
                            break;
                        case "Tc":
                            e_value.add(98.0);
                            break;
                        case "Ru":
                            e_value.add(101.072);
                            break;
                        case "Rh":
                            e_value.add(102.906);
                            break;
                        case "Pd":
                            e_value.add(106.421);
                            break;
                        case "Ag":
                            e_value.add(107.868);
                            break;
                        case "Cd":
                            e_value.add(112.412);
                            break;
                        case "In":
                            e_value.add(114.818);
                            break;
                        case "Sn":
                            e_value.add(118.711);
                            break;
                        case "Sb":
                            e_value.add(121.760);
                            break;
                        case "Te":
                            e_value.add(127.603);
                            break;
                        case "I":
                            e_value.add(126.904);
                            break;
                        case "Xe":
                            e_value.add(131.292);
                            break;
                        case "Cs":
                            e_value.add(132.905);
                            break;
                        case "Ba":
                            e_value.add(137.328);
                            break;
                        case "La":
                            e_value.add(139.906);
                            break;
                        case "Ce":
                            e_value.add(140.116);
                            break;
                        case "Pr":
                            e_value.add(140.908);
                            break;
                        case "Nd":
                            e_value.add(144.243);
                            break;
                        case "Pm":
                            e_value.add(145.0);
                            break;
                        case "Sm":
                            e_value.add(150.363);
                            break;
                        case "Eu":
                            e_value.add(151.964);
                            break;
                        case "Gd":
                            e_value.add(157.253);
                            break;
                        case "Tb":
                            e_value.add(158.925);
                            break;
                        case "Dy":
                            e_value.add(162.503);
                            break;
                        case "Ho":
                            e_value.add(164.930);
                            break;
                        case "Er":
                            e_value.add(167.263);
                            break;
                        case "Tm":
                            e_value.add(168.934);
                            break;
                        case "Yb":
                            e_value.add(173.04);
                            break;
                        case "Lu":
                            e_value.add(174.967);
                            break;
                        case "Hf":
                            e_value.add(178.492);
                            break;
                        case "Ta":
                            e_value.add(180.948);
                            break;
                        case "W":
                            e_value.add(183.841);
                            break;
                        case "Re":
                            e_value.add(186.207);
                            break;
                        case "Os":
                            e_value.add(190.233);
                            break;
                        case "Ir":
                            e_value.add(192.217);
                            break;
                        case "Pt":
                            e_value.add(195.078);
                            break;
                        case "Au":
                            e_value.add(196.967);
                            break;
                        case "Hg":
                            e_value.add(200.592);
                            break;
                        case "Tl":
                            e_value.add(204.383);
                            break;
                        case "Pb":
                            e_value.add(207.21);
                            break;
                        case "Bi":
                            e_value.add(208.980);
                            break;
                        case "Po":
                            e_value.add(209.0);
                            break;
                        case "At":
                            e_value.add(210.0);
                            break;
                        case "Rn":
                            e_value.add(222.0);
                            break;
                        case "Fr":
                            e_value.add(223.0);
                            break;
                        case "Ra":
                            e_value.add(226.0);
                            break;
                        case "Ac":
                            e_value.add(227.0);
                            break;
                        case "Th":
                            e_value.add(232.038);
                            break;
                        case "Pa":
                            e_value.add(231.036);
                            break;
                        case "U":
                            e_value.add(238.029);
                            break;
                        case "Np":
                            e_value.add(237.0);
                            break;
                        case "Pu":
                            e_value.add(244.0);
                            break;
                        case "Am":
                            e_value.add(243.0);
                            break;
                        case "Cm":
                            e_value.add(247.0);
                            break;
                        case "Bk":
                            e_value.add(247.0);
                            break;
                        case "Cf":
                            e_value.add(251.0);
                            break;
                        case "Es":
                            e_value.add(252.0);
                            break;
                        case "Fm":
                            e_value.add(257.0);
                            break;
                        case "Md":
                            e_value.add(258.0);
                            break;
                        case "No":
                            e_value.add(259.0);
                            break;
                        case "Lr":
                            e_value.add(262.0);
                            break;
                        case "Rf":
                            e_value.add(261.0);
                            break;
                        case "Db":
                            e_value.add(262.0);
                            break;
                        case "Sg":
                            e_value.add(263.0);
                            break;
                        case "Bh":
                            e_value.add(262.0);
                            break;
                        case "Hs":
                            e_value.add(265.0);
                            break;
                        case "Mt":
                            e_value.add(266.0);
                            break;
                        case "Ds":
                            e_value.add(269.0);
                            break;
                        case "Rg":
                            e_value.add(272.0);
                            break;
                        case "Cn":
                            e_value.add(285.0);
                            break;
                        case "Uut":
                            e_value.add(284.0);
                            break;
                        case "Fv":
                            e_value.add(289.0);
                            break;
                        case "Uup":
                            e_value.add(288.0);
                            break;
                        case "Lv":
                            e_value.add(292.0);
                            break;
                        case "Uus":
                            e_value.add(295.0);
                            break;
                        case "Uuo":
                            e_value.add(294.0);
                            break;

                        default:
                            count = 1;
                            break;
                    }

                }
//*************************************Invalid input*******************************/
                if (count ==1) {
                    output = "Invalid Chemical Compound";

                }
                else{
                    for (int i = 0; i< e_value.size();i++) {
                        total =total+(e_value.get(i)*(num.get(i)));
                    }
                    output="The Molar Mass of " + editvalue + " is " + total + "g/mol ";

                }
//*********************************Output***************************************//
                    textView2.setText(output);





            }
        });

    }


}
