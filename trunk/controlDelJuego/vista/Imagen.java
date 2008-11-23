package vista;
import modelo.Dibujable;
import modelo.SuperficieDeDibujo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

import modelo.Posicionable;
/*
 * Esta clase representa una imagen JPG abstrayendo al usuario de los detalles de Java2D
 * Simplemente requiere de una referencia al nombre del archivo JPG
 */
public class Imagen implements Dibujable{
	
	private String nombreArchivoImagen;
    private BufferedImage imagen;
    private Posicionable posicionable;
    
	public Imagen(){
		
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
		grafico.drawImage(this.imagen, this.posicionable.getPosicionX(), this.posicionable.getPosicionY(), null);
	}
	    
	public String getNombreArchivoImagen() {
		return nombreArchivoImagen;
	}

	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		this.nombreArchivoImagen = nombreArchivoImagen;
//		InputStream in = getClass().getResourceAsStream(this.nombreArchivoImagen);
//		JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
		try{
		
			InputStream in = new FileInputStream(nombreArchivoImagen);
		    JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
			this.imagen = decoder.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){

		}			
	}
	
	public Posicionable getPosicionable() {
		return posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		System.out.println("PosicionX:" + posicionable.getPosicionX()+" PosicionY: " + posicionable.getPosicionY());	
		this.posicionable = posicionable;
	}


}
