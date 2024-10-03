package and
import chisel3._
//extends is key word for inher
//module is a class in chisel
//gate will always be a derived class of parent class

//module start
class ands extends Module {
  // IO IS A function
  //WITH AN ARGUMENT OF ANOTHER CLASS BUNDLE
  //new keyword make object
  val io = IO (new Bundle{
    //1 is with 1.W 1 is input in bits
    //inputs for and gate
    //port and pin are inputs
    val a = Input(UInt(1.W))
    val b  = Input(UInt(1.W))
   //outputs for and gate
    val c = Output(UInt(1.W))
  })//module ends
  // outside scope to call inputs
  //class.attributes
  //:= is wire/connecting
  io.c := io.a & io.b

}
//code that calls module is called test bench