package imd.ntub.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import imd.ntub.myapplication.databinding.ActivitySecond2Binding

class SecondActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivitySecond2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second2)
        binding = ActivitySecond2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOk.setOnClickListener {
            //food
            val okFood1 = binding.rbtnRamen.isChecked
            val okFood2 = binding.rbtnSushi.isChecked
            val okFood3 = binding.rbtnTakoyaki.isChecked
            intent.putExtra("Food1",okFood1)
            intent.putExtra("Food2",okFood2)
            intent.putExtra("Food3",okFood3)
            //drink
            val okDrink1 = binding.rbtnCola.isChecked
            val okDrink2 = binding.rbtnTea.isChecked
            intent.putExtra("Drink1",okDrink1)
            intent.putExtra("Drink2",okDrink2)
            //snack
            val okFries = binding.chbFries.isChecked
            val okJelly = binding.chbJelly.isChecked
            intent.putExtra("Snack1",okFries)
            intent.putExtra("Snack2",okJelly)
            //cost
            var totalCost = 0
            if (binding.rbtnRamen.isChecked){
                totalCost += 60
            }else if (binding.rbtnSushi.isChecked){
                totalCost += 50
            }else if (binding.rbtnTakoyaki.isChecked){
                totalCost += 10
            }else{
                totalCost += 0
            }

            if (binding.rbtnCola.isChecked){
                totalCost += 30
            }else if(binding.rbtnTea.isChecked){
                totalCost +=20
            }else{
                totalCost += 0
            }

            if (binding.chbFries.isChecked){
                totalCost += 15
            }
            if (binding.chbJelly.isChecked){
                totalCost +=10
            }
            intent.putExtra("totCost",totalCost.toString())
            setResult(RESULT_OK,intent)
            //AlertDialog
            AlertDialog.Builder(this)
                .setTitle("確定訂單")
                .setMessage("即將送出訂單，是否確定送出")
                .setPositiveButton("確定"){dialog,i->
                    finish()
                }
                .setNegativeButton("不確定"){dialog,i->
                }
                .show()
        }
    }
    override fun onResume() {
        super.onResume()
        binding.rbtnRamen.isChecked = intent.getBooleanExtra("Food1", false)
        binding.rbtnSushi.isChecked = intent.getBooleanExtra("Food2", false)
        binding.rbtnTakoyaki.isChecked = intent.getBooleanExtra("Food3", false)
        binding.rbtnCola.isChecked = intent.getBooleanExtra("Drink1",false)
        binding.rbtnTea.isChecked = intent.getBooleanExtra("Drink2",false)
        binding.chbFries.isChecked = intent.getBooleanExtra("Snack1",false)
        binding.chbJelly.isChecked = intent.getBooleanExtra("Snack2",false)
        binding.totCost.setText(intent.getStringExtra("totCost"))
    }
}