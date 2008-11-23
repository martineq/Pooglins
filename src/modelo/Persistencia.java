package modelo;

//Para crear el archivo XML.-
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

//Para escribir el archivo XML en disco.-
import org.dom4j.io.XMLWriter;
import java.io.*;

/**
 * Clase que guarda todos los objetos vivos del programa (Persistencia).-
 * @author Mart.-
 * @since 21/11/08
 */
public class Persistencia {

  private Document documento;
	
  public Persistencia(){
	documento = null;
  }

  public Element crearRaiz(){
	  
	//Con esto creo el documento donde se va a encontrar todos los objetos.-
	documento = DocumentHelper.createDocument();

	//Creo el elemento raíz del documento.-
	Element raiz = documento.addElement("raiz");

	//Le agrego comentarios e instrucciones de proceso.-
	raiz.addComment("Raiz del Programa2");
	  
	return raiz;
  }

  public void guardarDocumento(){
	  
	  try {
			FileWriter archivo = new FileWriter("Pooglins.xml");
			XMLWriter escritor = new XMLWriter(archivo);
			escritor.write(documento);
			escritor.close();
		} catch (IOException e) {
			System.out.println("Error de escritura de archivo");
			e.printStackTrace();
		}
	  
  }
  
  
  /** Clase que genera un archivo XML de persistencia de "ejemplo"
   * @author Mart.- 
   */
public void generarDocumentoEjemplo(){

	//Con esto creo el documento donde se va a encontrar todos los objetos.-
	Document documento = DocumentHelper.createDocument();

	//Creo el elemento raíz del documento.-
	Element raiz = documento.addElement("raiz");

	//Le agrego comentarios e instrucciones de proceso.-
	raiz.addComment("Raiz del documento");
	raiz.addProcessingInstruction("Objetivo","Texto");

	//Inserto elementos en la raíz.-
	Element elem1 = raiz.addElement("elem1");

	//Inserto Atributos y texto al elemento.-
	elem1.addAttribute("Nombre","Primer elemento");
	elem1.addAttribute("Numero","55");
	elem1.addText("estoes texto");

	//Así con otros elementos.-
	Element elem2 = raiz.addElement("elemento2");
	elem2.addAttribute("nombre","El segundo");
	elem2.addAttribute("Numero", "0303");

	//Agrego un tercer elemento dentro del segundo
	Element elem3 = elem2.addElement("elemnton3");
	raiz.addProcessingInstruction("NOSE","queesesto");
	elem3.addAttribute("nombre","joshe");
	elem3.addText("que pasha joshe");

	try {
		FileWriter archivo = new FileWriter("Ejemplo.xml");
		XMLWriter escritor = new XMLWriter(archivo);
		escritor.write(documento);
		escritor.close();
	} catch (IOException e) {
		System.out.println("error de archivo");
		e.printStackTrace();
	}

  }	

}
