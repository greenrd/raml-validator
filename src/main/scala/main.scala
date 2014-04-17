import java.io.{PrintWriter, File}
import org.raml.emitter.RamlEmitter
import org.raml.model.Raml
import org.raml.parser.visitor.{RamlDocumentBuilder, RamlValidationService}
import org.raml.validation.ValidationLogger
import scala.util.{Failure, Success, Try}

object Main {


  def main(args: Array[String]): Unit = {

    val usage =
      """ Usage: raml [-r | --resource] raml_name [-v | --validation]  // Validating raml.
        | Usage: raml [-r | --resource] raml_name [-c | --compile] compile_file_name // Compiling raml into one file.
      """.stripMargin

    val resource = math.max(args.indexOf("-r"), args.indexOf("--resource"))

    if (resource > -1) {

      val validation = math.max(args.indexOf("-v"), args.indexOf("--validation"))

      //validation
      if (validation > -1) {
        println( s"""Validating file "${args(resource + 1)}"""")
        Try(new RamlDocumentBuilder().build(new File(args(resource + 1)))) match {
          case Success(v) => println("Validation successful!")
          case Failure(e) => {
            println("Failed in parsing your raml")
            println(ValidationLogger.history.head)
            println("Exception message : \n" + e.getMessage)
          }
        }
      }

      val compilation = math.max(args.indexOf("-c"), args.indexOf("--compile"))

      if (compilation > -1) {
        println( s"""Compiling file "${args(resource + 1)}" into "${args(compilation + 1)}""")
        Try {
          val raml: Raml = new RamlDocumentBuilder().build(new File(args(resource + 1)))
          val emitter = new RamlEmitter
          val writer = new PrintWriter(args(compilation + 1))
          writer.write(emitter.dump(raml))
          writer.flush()
        } match {
          case Success(_) => println("Finished")
          case Failure(e) => {
            println("Failed in parsing your raml")
            println(ValidationLogger.history.head)
            println("Exception message : \n" + e.getMessage)
          }
        }

      }
    } else {
      println(usage)
    }

  }
}