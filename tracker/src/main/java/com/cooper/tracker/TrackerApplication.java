package com.cooper.tracker;

import com.cooper.tracker.UI.ProjectFileChooser;
import com.cooper.tracker.project.*;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import versionControl.HotKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


@SpringBootApplication
public class TrackerApplication extends JFrame {
	public TrackerApplication() {
		initUI();
	}

	private void initUI() {
		ProjectFileChooser fileChooserHelper = new ProjectFileChooser();

		var quitButton = new JButton("Quit");
		quitButton.addActionListener((ActionEvent event) -> {
			fileChooserHelper.chooseFile(quitButton);

			//System.exit(0);
		});
		createLayout(quitButton);
		setTitle("Quit button");
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);



	}

	private void createLayout(JComponent... arg){
		var pane = getContentPane();
		var gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[0])
		);

		gl.setVerticalGroup(gl.createSequentialGroup()
				.addComponent(arg[0]));

	}
//	private void createBoxLayout(JComponent... arg)
//	{
//		JPanel panels[];
//		panels = new JPanel[2];
//		for(int i = 0; i < panels.length; i++)
//		{
//			JButton testButton = new JButton("text" + i);
//			panels[i] = new JPanel();
//			panels[i].add(testButton);
//
//		}
//		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
//	}
	public static void main(String[] args) {

		GlobalScreen.addNativeKeyListener(new HotKeyListener());

//		HotKeyListener hotKeyListener = new HotKeyListener();
//		hotKeyListener.promptSave();

		var ctx = new SpringApplicationBuilder(TrackerApplication.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {

			var ex = ctx.getBean(TrackerApplication.class);
			ex.setVisible(true);
		});

		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}
		System.out.println("hihi");
		//loadTileEntryData();
	}
	public static void loadTileEntryData(){
		//this works!
		ProjectConsumer consumer = new ProjectConsumer();
		Project[] projArray = consumer.getProjects();
		for (Project proj : projArray) {
			System.out.println(proj.getName());
		}

	}

	@Bean
	public static WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}

}




//@SpringBootApplication
//public class TrackerApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(TrackerApplication.class, args);
//		//Schedule a job for the event-dispatching thread:
//		//creating and showing this application's GUI.
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				createAndShowGUI();
//			}
//		});
//
//	}
//	private static void createAndShowGUI() {
//		//Create and set up the window.
//		JFrame frame = new JFrame("HelloWorldSwing");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		//Add the ubiquitous "Hello World" label.
//		JLabel label = new JLabel("Hello World");
//		frame.getContentPane().add(label);
//
//		//Display the window.
//		frame.pack();
//		frame.setVisible(true);
//	}
//
//}
