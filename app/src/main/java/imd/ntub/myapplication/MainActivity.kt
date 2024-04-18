//組員：11056004、11056014、11056016

package imd.ntub.myapplication

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import imd.ntub.myapplication.databinding.ActivityMainBinding
import javax.net.ssl.SSLSessionBindingEvent

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var food1 = false
    private var food2 = false
    private var food3 = false
    private var drink1 = false
    private var drink2 = false
    private var snack1 = false
    private var snack2 = false
    private var cost = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView((binding.root))

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
            if(result.resultCode == RESULT_OK){
                val data = result.data
                //Food
                binding.txtFood1.setText(
                    if (data?.getBooleanExtra("Food1",false) == true){
                        "Ramen"
                    }else if(data?.getBooleanExtra("Food2",false) == true){
                        "Sushi"
                    }else if(data?.getBooleanExtra("Food3",false) == true){
                        "Takoyaki"
                    }else{
                        "non"
                    }
                )
                this.food1 = data?.getBooleanExtra("Food1",food1)!!
                this.food2 = data?.getBooleanExtra("Food2",food2)!!
                this.food3 = data?.getBooleanExtra("Food3",food3)!!
                //Drink
                binding.txtDrinks1.setText(
                    if (data?.getBooleanExtra("Drink1",false) == true){
                        "Cola"
                    }else if (data?.getBooleanExtra("Drink2",false) == true){
                        "Black Tea"
                    }else{
                        "non"
                    }
                )
                this.drink1 = data?.getBooleanExtra("Drink1",drink1)!!
                this.drink2 = data?.getBooleanExtra("Drink2",drink2)!!
                //Snack
                binding.txtSnack1.setText(
                    if (data?.getBooleanExtra("Snack1",false) == true && data?.getBooleanExtra("Snack2",false) == true){
                        "fries and jelly"
                    }else if(data?.getBooleanExtra("Snack1",false) == false && data?.getBooleanExtra("Snack2",false) == true){
                        "jelly"
                    }else if (data?.getBooleanExtra("Snack1",false) == true && data?.getBooleanExtra("Snack2",false) == false){
                        "fries"
                    }else{
                        "non"
                    }
                )
                this.snack1 = data?.getBooleanExtra("Snack1", snack1)!!
                this.snack2 = data?.getBooleanExtra("Snack2", snack2)!!
                //cost
                binding.txtCost1.setText(data?.getStringExtra("totCost"))
            }
            else{
                binding.txtFood1.setText("")
                binding.txtSnack1.setText("")
                binding.txtDrinks1.setText("")
                binding.txtCost1.setText("non")
            }
        }
        binding.btnClick.setOnClickListener {
            val intent = Intent(this,SecondActivity2::class.java)
                .apply {
                    putExtra("Food1",food1)
                    putExtra("Food2",food2)
                    putExtra("Food3",food3)
                    putExtra("Drink1",drink1)
                    putExtra("Drink2",drink2)
                    putExtra("Snack1",snack1)
                    putExtra("Snack2", snack2)
                    putExtra("totCost",cost)
                }
            launcher.launch((intent))
        }
    }
}