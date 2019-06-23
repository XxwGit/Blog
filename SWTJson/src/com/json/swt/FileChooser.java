package com.json.swt;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.json.thread.JsonFileThread;
import com.json.thread.JsonFolderThread;

public class FileChooser {

	protected Shell shell;
	private Text sourseFile;
	private Text targetFile;
	private Text fileNameText;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	public String sourceFileString;
	public String targetFileString;
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileChooser window = new FileChooser();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 500);
		shell.setText("Xml2Json");

		Label sourceLabel = new Label(shell, SWT.NONE);
		sourceLabel.setBounds(139, 127, 54, 20);
		sourceLabel.setSize(80, 55);
		sourceLabel.setText("Ŀ���ļ��У�");

		sourseFile = new Text(shell, SWT.BORDER);
		sourseFile.setBounds(233, 127, 300, 20);

		Button sourseFileButton = new Button(shell, SWT.NONE);
		sourseFileButton.setBounds(550, 127, 95, 20);
		sourseFileButton.setText("ѡȡĿ���ļ���");
		sourseFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		        jfc.showDialog(new JLabel(), "ѡ���ļ���");  
		        
		        File file=jfc.getSelectedFile();  
		        if(file.isDirectory()){  
		            System.out.println("�ļ���:"+file.getAbsolutePath());  
		        }else if(file.isFile()){  
		            System.out.println("�ļ�:"+file.getAbsolutePath());  
		        }  
		        sourseFile.setText(file.getAbsolutePath());
		        sourceFileString = file.getAbsolutePath();
			}
		});

		Label targetLabel = new Label(shell, SWT.NONE);
		targetLabel.setBounds(139, 181, 54, 20);
		targetLabel.setSize(80, 55);
		targetLabel.setText("����ļ��У�");

		targetFile = new Text(shell, SWT.BORDER);
		targetFile.setBounds(233, 177, 300, 20);
		Button targetFileButton = new Button(shell, SWT.NONE);
		targetFileButton.setBounds(550, 181, 95, 20);
		targetFileButton.setText("ѡȡ����ļ���");
		targetFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		        jfc.showDialog(new JLabel(), "ѡ��");  
		        File file=jfc.getSelectedFile();  
		        if(file.isDirectory()){  
		            System.out.println("�ļ���:"+file.getAbsolutePath());  
		        }else if(file.isFile()){  
		            System.out.println("�ļ�:"+file.getAbsolutePath());  
		        }  
		        targetFile.setText(file.getAbsolutePath());
		        targetFileString = file.getAbsolutePath();
			}
		});

		Button Begin = new Button(shell, SWT.NONE);
		Begin.setBounds(213, 235, 72, 22);
		Begin.setText("��ʼת��");
		Begin.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				String path =sourceFileString;
		        File file = new File(path);
		        if(file.isDirectory()){
		            System.out.println("���ļ���");
		            JsonFolderThread jsonThread = new JsonFolderThread(sourceFileString, targetFileString);
					Thread thread = new Thread(jsonThread);
					thread.run();
					MessageDialog.openInformation(shell, "��ʾ", "ת���ɹ�");
		        }
		        if(file.isFile()){
		            System.out.println("���ļ�");
		            JsonFileThread jsonFileThread = new JsonFileThread(sourceFileString, targetFileString);
		            Thread thread = new Thread(jsonFileThread);
					thread.run();
					MessageDialog.openInformation(shell, "��ʾ", "ת���ɹ�");
		        }
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
}