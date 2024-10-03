//lab1/exercise2
//Make the counter to reset its count to 0 when its MSB (most significant bit) changes from 0 to 1.
package lab1
import chisel3 . _
class Counter2 ( counterBits : UInt ) extends Module {
val io = IO ( new Bundle {
val result = Output ( Bool () )
})
val max = (0. U << counterBits ) - 1. U
val count = RegInit (0. U (4. W ) )
when ( count === 1.U ) {
count := 0. U
} .otherwise {
count := count + 1. U
}
io . result := count (3. U )
}
