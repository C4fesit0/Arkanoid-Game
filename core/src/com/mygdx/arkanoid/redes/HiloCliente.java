package com.mygdx.arkanoid.redes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import com.mygdx.arkanoid.Arkanoid;
import com.mygdx.arkanoid.utiles.Utiles;

public class HiloCliente extends Thread {

	private InetAddress ipServidor;
	private final int puertoServidor = 25565;
	private DatagramSocket sc;
	private Arkanoid arka;
	private boolean fin = false;
	JFrame frame;

//    public HiloCliente(Arkanoid app) {
//        this.arka = app;
//        frame = new JFrame();
//        try {
//        	ipServidor = InetAddress.getByName(JOptionPane.showInputDialog(frame,"Ingrese la IP"));
//        	sc = new DatagramSocket();
//            System.out.println(sc.getInetAddress());
//        } catch (SocketException | UnknownHostException e) {
//            e.printStackTrace();
//        }
//        enviarMensaje("Conexion");
//        System.out.println("Se ENVIO CONEXION");
//    }

	public HiloCliente(Arkanoid arka) {
		this.arka = arka;

		try {

			ipServidor = InetAddress.getByName("255.255.255.255");
			sc = new DatagramSocket();
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
		enviarMensaje("Conexion");
		System.out.println("Se ENVIO CONEXION");
	}

	@Override
	public void run() {
		do {
			byte[] data = new byte[1024];
			DatagramPacket paquete = new DatagramPacket(data, data.length);
			try {

				sc.receive(paquete);
			} catch (IOException e) {
				e.printStackTrace();
			}
			procesarMensaje(paquete);
		} while (!fin);
	}

	private void procesarMensaje(DatagramPacket dp) {
		String msg = (new String(dp.getData())).trim();
		String[] mensajeParametrizado = msg.split("-");// split separa los mensajes con un - en posicions del array
		if (msg.equals("Empieza")) {
			System.out.println("COMIENZA JUEGO");
			Utiles.jugar = true;
		} else if (msg.equals("TerminaJuego")) {
			Utiles.jugar = false;
		}
		if (mensajeParametrizado.length == 2) {

			if (mensajeParametrizado[0].equals("OK")) {
				System.out.println("SE CONECTO CON EXITO AL SERVER");
				ipServidor = dp.getAddress();
				arka.nroJugador = Integer.parseInt(mensajeParametrizado[1]);
				System.out.println("JUGADOR:" + arka.nroJugador);
			}

		} else if (mensajeParametrizado[0].equals("Actualizar")) {

			if (mensajeParametrizado[1].equals("P1")) {
				System.out.println("posX P1:" + mensajeParametrizado[2]);
				try {
					float posX = Float.parseFloat(mensajeParametrizado[2]);
					arka.p1.setPosX(posX);
				} catch (Exception e) {
				}
				System.out.println("pelota 1: " + mensajeParametrizado[3] + " " + mensajeParametrizado[4]);
				try {
					float posXpe = Float.parseFloat(mensajeParametrizado[3]);
					arka.pe1.setPosX(posXpe);
					float posYpe = Float.parseFloat(mensajeParametrizado[4]);
					arka.pe1.setPosY(posYpe);
				} catch (Exception e) {
				}

			} else if (mensajeParametrizado[1].equals("P2")) {

				System.out.println("posX P2:" + mensajeParametrizado[2]);
				try {
					float posX = Float.parseFloat(mensajeParametrizado[2]);
					arka.p2.setPosX(posX);
					System.out.println("pelota 2: " + mensajeParametrizado[3] + " " + mensajeParametrizado[4]);
					float posXpe = Float.parseFloat(mensajeParametrizado[3]);
					arka.pe2.setPosX(posXpe);
					float posYpe = Float.parseFloat(mensajeParametrizado[4]);
					arka.pe2.setPosY(posYpe);
					System.out.println("Se actualizo pelota 2");
				} catch (Exception e) {}

			}else if(mensajeParametrizado[1].equals("B1"))//NUEVO
			{
				arka.bloque1[Integer.parseInt(mensajeParametrizado[2])].setPoxY(Float.parseFloat(mensajeParametrizado[3]));
				System.out.println("B1 bloque:"+Integer.parseInt(mensajeParametrizado[2])+" posY:"+Float.parseFloat(mensajeParametrizado[3]));
			}else if(mensajeParametrizado[1].equals("B2"))
			{
				arka.bloque1[Integer.parseInt(mensajeParametrizado[2])].setPoxY(Float.parseFloat(mensajeParametrizado[3]));
				System.out.println("B2 bloque:"+Integer.parseInt(mensajeParametrizado[2])+" posY:"+Float.parseFloat(mensajeParametrizado[3]));
			}

		}

	}

	public void enviarMensaje(String msg) {

		byte[] data = msg.getBytes();
		DatagramPacket dataPacket = new DatagramPacket(data, data.length, ipServidor, puertoServidor);
		try {
			sc.send(dataPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
