/*
import chisel3 . _

object task3 {
// ALU Operations , may expand / modify in future
val ALU_ADD = 0. U (4. W )
val ALU_SUB= 1. U (4. W )
val ALU_AND= 2. U (4. W )
val ALU_OR= 3. U (4. W )
val ALU_XOR= 4. U (4. W )
val ALU_SLT= 5. U (4. W )
val ALU_SLL= 6. U (4. W )
val ALU_SLTU= 7. U (4. W )
val ALU_SRL= 8. U (4. W )
val ALU_SRA= 9. U (4. W )
val ALU_COPY_A = 10. U (4. W )
val ALU_COPY_B = 11. U (4. W )
val ALU_XXX= 15. U (4. W )
}

trait Config {
// word length configuration parameter
val WLEN
= 32
// ALU operation control signal width
val ALUOP_SIG_LEN = 4
}
class task3 extends Bundle with Config {
val in_A= Input ( UInt ( WLEN . W ) )
val in_B= Input ( UInt ( WLEN . W ) )
val alu_Op= Input ( UInt ( ALUOP_SIG_LEN . W ) )
val out= Output ( UInt ( WLEN . W ) )
val sum= Output ( UInt ( WLEN . W ) )
}
class ALU extends Module with Config {

val out =
Mux ( io . alu_Op === ALU_ADD . U , ( io . in_A + io . in_B ) ,
Mux ( io . alu_Op ===ALU_SUB . U , ( io . in_A - io . in_B ) ,
Mux ( io . alu_Op === ALU_SLT . U , ( io . in_A < io . in_B ) ,
Mux ( io . alu_Op === ALU_SLTU .U , ( io . in_A < io . in_B ) ,
Mux ( io . alu_Op === ALU_SRA . U , ( io . in_A >> io . in_B ) ,
Mux ( io . alu_Op === ALU_SRL .U , ( io . in_A >> io . in_B ) ,
Mux ( io . alu_Op === ALU_SLL .U , ( io . in_A << io . in_B ) ,
Mux ( io . alu_Op === ALU_AND .U , ( io . in_A & io . in_B ) ,
Mux ( io . alu_Op === ALU_OR .U , ( io . in_A | io . in_B ) ,
Mux ( io . alu_Op === ALU_XOR .U , ( io . in_A ^ io . in_B ) ,
Mux ( io . alu_Op === ALU_COPY_A .U , io . in_A ,
Mux ( io . alu_Op === ALU_COPY_A .U , io . in_B , 0. U ) ) ) ) ) ) ) ) ))))
io . out := out
io . sum := sum
}*/