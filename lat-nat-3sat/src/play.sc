object play {
  println("Given an instance, phi, of NAE3SAT and a function, f, check whether f is a solution to phi.")
                                                  //> Given an instance, phi, of NAE3SAT and a function, f, check whether f is a s
                                                  //| olution to phi.
  
  type Var = Int
  
  def NAE3sol(ls: List[(Var, Var, Var)], f:Var => Boolean) : Boolean = ls match {
  	case List () => true
  	case h :: tail => (f(h._1), f(h._2), f(h._3)) match {
  								 case (true,true,true) => false
  								 case (false, false, false) => false
  								 case _ => NAE3sol(tail, f)
  								 }
  	}                                         //> NAE3sol: (ls: List[(play.Var, play.Var, play.Var)], f: play.Var => Boolean)B
                                                  //| oolean
  	
  	val phi = List((0,1,2), (2,4,0), (3,2,6)) //> phi  : List[(Int, Int, Int)] = List((0,1,2), (2,4,0), (3,2,6))
  	def myf (v: Var) : Boolean = v match {
  		case 0 => true
  		case 1 => true
      case 2 => true
      case 3 => false
      case 4 => false
      case 6 => false
  	}                                         //> myf: (v: play.Var)Boolean
  	
  	NAE3sol(phi, myf)                         //> res0: Boolean = false
  		
  	
   
}