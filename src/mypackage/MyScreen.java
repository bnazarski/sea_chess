package mypackage;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.MainScreen;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */

public final class MyScreen extends MainScreen {
	/**
	 * Creates a new MyScreen object
	 */
	private static final int DEFAULT_SIZE = 3;
	private GridFieldManager sea_chess_table;
	private LabelField label;
	player player1 = new player("pesho", 'x', true);
	player player2 = new player("ivan", '0', false);
	gameEngine myGameEngine = new gameEngine(DEFAULT_SIZE);

	public MyScreen() {
		super();

		label = new LabelField("It's " + player1.getPlayerName() + " turn!",
				LabelField.FIELD_BOTTOM | LabelField.FIELD_RIGHT);
		add(label);
		// label.setText("It's "+player1.getPlayerName()+ " turn!", -1,-1);
		FieldChangeListener listener = new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				ButtonField buttonField = (ButtonField) field;

				for (byte l = 0; l < sea_chess_table.getRowCount(); l++)
					for (byte m = 0; m < sea_chess_table.getColumnCount(); m++)

						if (buttonField == sea_chess_table.getFieldAtCell(l, m)) {
							// //
							if (player1.IsItMyTurn()) {
								if (myGameEngine.CheckAndSetField(l, m,player1.getPlayerSign())) {
									String sign = "";
									sign += player1.getPlayerSign();
									buttonField.setLabel(sign);
									if (myGameEngine.IsLineAchieved(l, m)) {
										// end game
										label.setText(player1.getPlayerName()
												+ " wins!", 0, -1);
										Dialog.inform(label.getText());
										//restartGame();
									} 
									else
									{	if(myGameEngine.hasMoreMoves())
										{
										player1.SetTurn(false);
										player2.SetTurn(true);
										label.setText("It's "+ player2.getPlayerName()+ " turn!", 0, -1);
										}
										else
											Dialog.inform("No one wins!");
											//restartGame();
										
									}
								}

							} 
							else 
							{	if (player2.IsItMyTurn()) {
								if (myGameEngine.CheckAndSetField(l, m,player2.getPlayerSign())) {
									String sign = "";
									sign += player2.getPlayerSign();
									buttonField.setLabel(sign);
									if (myGameEngine.IsLineAchieved(l, m)) {
										// end game
										label.setText(player2.getPlayerName()+ " wins!", 0, -1);
										Dialog.inform(label.getText());
										//restartGame();
									} else {
										if(myGameEngine.hasMoreMoves()){
										player1.SetTurn(true);
										player2.SetTurn(false);
										label.setText("It's "+ player1.getPlayerName()+ " turn!", 0, -1);
									}
									else
										Dialog.inform("No one wins!");
										//restartGame();
									
									}			
									}
								}
							}
						}
			}
		};

		// Set the displayed title of the screen
		setTitle("Sea Chess");
		final ButtonField buttonField_1 = new ButtonField("",
				ButtonField.CONSUME_CLICK);
		// add( buttonField_1 );
		buttonField_1.setChangeListener(listener);
		ButtonField buttonField_2 = new ButtonField("",
				ButtonField.CONSUME_CLICK);
		// add( buttonField_1 );
		buttonField_2.setChangeListener(listener);
		ButtonField buttonField_3 = new ButtonField("",
				ButtonField.CONSUME_CLICK);
		// add( buttonField_1 );
		buttonField_3.setChangeListener(listener);
		ButtonField buttonField_4 = new ButtonField("",
				ButtonField.CONSUME_CLICK);
		// add( buttonField_1 );
		buttonField_4.setChangeListener(listener);
		ButtonField buttonField_5 = new ButtonField("",
				ButtonField.CONSUME_CLICK);
		// add( buttonField_1 );
		buttonField_5.setChangeListener(listener);
		ButtonField buttonField_6 = new ButtonField("",
				ButtonField.CONSUME_CLICK);
		// add( buttonField_1 );
		buttonField_6.setChangeListener(listener);
		ButtonField buttonField_7 = new ButtonField("",
				ButtonField.CONSUME_CLICK);
		// add( buttonField_1 );
		buttonField_7.setChangeListener(listener);
		ButtonField buttonField_8 = new ButtonField("",
				ButtonField.CONSUME_CLICK);
		// add( buttonField_1 );
		buttonField_8.setChangeListener(listener);
		ButtonField buttonField_9 = new ButtonField("",
				ButtonField.CONSUME_CLICK);
		// add( buttonField_1 );
		buttonField_9.setChangeListener(listener);
		sea_chess_table = new GridFieldManager(DEFAULT_SIZE,DEFAULT_SIZE,
				GridFieldManager.FIELD_HCENTER | GridFieldManager.AUTO_SIZE
						| GridFieldManager.FIELD_VCENTER);
		// for ( int i=0;i<9;i++)
		// {
		sea_chess_table.add(buttonField_1);
		sea_chess_table.add(buttonField_2);
		sea_chess_table.add(buttonField_3);
		sea_chess_table.add(buttonField_4);
		sea_chess_table.add(buttonField_5);
		sea_chess_table.add(buttonField_6);
		sea_chess_table.add(buttonField_7);
		sea_chess_table.add(buttonField_8);
		sea_chess_table.add(buttonField_9);
		add(sea_chess_table);
		// }

	}
	////restart the game...
	/*
	public void restartGame() {
		ButtonField buttonField;
		myGameEngine = new gameEngine(DEFAULT_SIZE);
		for (int y = 0; y < DEFAULT_SIZE; y++) {
			for (int x = 0; x < DEFAULT_SIZE; x++) {
				buttonField=(ButtonField) sea_chess_table.getFieldAtCell(y, x);
				buttonField.setLabel("");
			}
		}
		label.setText("It's " + player1.getPlayerName() + " turn!", 0, -1);
	}*/
}
