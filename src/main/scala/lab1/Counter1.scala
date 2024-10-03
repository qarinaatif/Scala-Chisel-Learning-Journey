/*lab1/exercise1
Q.Modify the counter in Listing 1.7 to use SInt type count.
import chisel3 . _
class Counter ( counterBits : UInt ) extends Module {
val io = IO ( new Bundle {
val result = Output ( Bool () )
})
val max = (1. U < < counterBits ) - 1. U
val count = RegInit (0. U (16. W ) )
*/

package lab1
import chisel3._
class Counter1(counterBits: Int) extends Module {
  val io = IO(new Bundle {
    val result = Output(Bool())
  })
  val max = ((1.S << counterBits)-1.S)
  val count = RegInit(0.S(16.W))
  when(count === max ) {
    count := 0.S
  } .otherwise {
    count := count + 1.S
  }
  io.result := count(15)
}


