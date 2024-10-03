//lab1/assignment2
//Define a class in Scala that implements an up-down counter. The counter starts from 0,
//counts up to a pre-defined value and then counts down to zero. It must repeats it counting and set
//io.out to high for one clock cycle when it reach either maximum or minimum values.
package lab1
import chisel3 . _
import chisel3 . util . _
import java . io . File
class Counter4( n : Int ) extends Module {
  val io = IO ( new Bundle {
  val data_in = Input ( UInt ( n . W ) )
  val reload = Input ( Bool () )
  val out = Output ( Bool () )
  })
  
val counter = RegInit (0. U ( n . W ) )
val max_count = RegInit (6. U ( n . W ) )
// Your code
when(io.reload) {
    counter := 0.U
  } .elsewhen(counter === max_count) {
    counter := counter - 1.U
  } .elsewhen(counter === 0.U) {
    counter := counter + 1.U} 
}
