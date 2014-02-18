package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagem {
	
	private BufferedImage imagem;
	private File file;
	
	public Imagem(BufferedImage img) {
		this.file = new File("");
		this.imagem = img;
	}
	
	public Imagem(String file) throws IOException {
		this.file = new File(file);
		this.imagem = ImageIO.read(this.file);
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
