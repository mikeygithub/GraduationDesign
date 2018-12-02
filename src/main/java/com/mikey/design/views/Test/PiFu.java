//package com.mikey.design.views.Test;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.UIManager;
//
//import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
//
//public class PiFu {
//
//	public JFrame frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PiFu window = new PiFu();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public PiFu() {
//		try {
//
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
//
//			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//
//			UIManager.put("RootPane.setupButtonVisible",false);
//
//			} catch (Exception e) {
//
//			// TODO Auto-generated catch block
//
//			e.printStackTrace();
//
//			}
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//
//}
