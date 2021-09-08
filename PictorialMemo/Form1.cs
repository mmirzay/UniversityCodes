using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace PictorialMemo
{
    public partial class Form1 : Form
    {
        static int lev = 3;
        static int currentLev = 0;
        static int currentRand = -1;
        static int randCounter = -1;
        static int timerCounter = 0;
        static int rand = 5;
        static int icell = 10;
        static int rcell = 15;
        static int score = 0;
        static int topScore = 388;
        bool [][][][]paths =new bool[lev][][][];
        int[] randomArr = new int [5];
        public Form1()
        {
            InitializeComponent();
            score = 0;
            lblTopScore.Text = "Top Score: " + topScore;
            for (int i = 0; i < 5; i++)
                randomArr[i] = -1;
            while (randomArr[4] == -1)
            {
                int randNum = new Random(System.DateTime.Now.Millisecond).Next() % 5;
                for (int i = 0; i < 5; i++)
                {
                    if (randomArr[i] == -1)
                    {
                        randomArr[i] = randNum;
                        break;
                    }
                    else if (randNum == randomArr[i])
                        break;
                }
            }            
            for (int i = 0; i < lev; i++)
                paths[i] = new bool[rand][][];
            for (int i = 0; i < lev; i++)
                for (int j = 0; j < rand; j++)
                    paths[i][j] = new bool[icell][];
            for (int i = 0; i < lev; i++)
                for (int j = 0; j < rand; j++)
                    for (int k = 0; k < icell; k++)
                        paths[i][j][k] = new bool[rcell];
            // level 1 random 1 
            for(int i=0;i<=12;i++)
                paths[0][0][0][i]=true;
            for (int j = 0; j <=6; j++)
                paths[0][0][j][12] = true;
            for (int i = 12; i <= 14; i++)
                paths[0][0][6][i] = true;
            for (int j = 6; j <= 9; j++)
                paths[0][0][j][14] = true;
            // end- level 1 random 1 
            // level 1 random 2             
            for (int j = 0; j <= 2; j++)
                paths[0][1][j][0] = true;
            for (int i = 0; i <= 14; i++)
                paths[0][1][2][i] = true;
            for (int j = 2; j <= 9; j++)
                paths[0][1][j][14] = true;
            // end- level 1 random 2 
            // level 1 random 3             
            for (int j = 0; j <= 6; j++)
                paths[0][2][j][0] = true;
            for (int i = 0; i <= 3; i++)
                paths[0][2][6][i] = true;
            for (int j = 6; j <= 9; j++)
                paths[0][2][j][3] = true;
            for (int i = 3; i <= 14; i++)
                paths[0][2][9][i] = true;
            // end- level 1 random 3
            // level 1 random 4 
            for (int i = 0; i <= 2; i++)
                paths[0][3][0][i] = true;
            for (int j = 0; j <= 5; j++)
                paths[0][3][j][2] = true;
            for (int i = 2; i <= 14; i++)
                paths[0][3][5][i] = true;
            for (int j = 5; j <= 9; j++)
                paths[0][3][j][14] = true;
            // end- level 1 random 4
            // level 1 random 5            
            for (int j = 0; j <= 6; j++)
                paths[0][4][j][0] = true;
            for (int i = 0; i <= 5; i++)
                paths[0][4][6][i] = true;
            for (int j = 6; j <= 9; j++)
                paths[0][4][j][5] = true;
            for (int i = 5; i <= 14; i++)
                paths[0][4][9][i] = true;
            // end- level 1 random 5
            // level 2 random 1            
            for (int j = 0; j <= 1; j++)
            {
                paths[1][0][0][j] = true;
                paths[1][0][j+8][14] = true;
            }
            for (int i = 0; i <= 2; i++)
            {
                paths[1][0][i][1] = true;
                paths[1][0][i+2][3] = true;
                paths[1][0][i+4][5] = true;
                paths[1][0][i+6][7] = true;
                paths[1][0][2][i+1] = true;
                paths[1][0][4][i + 3] = true;
                paths[1][0][6][i + 5] = true;
            }
            for (int j = 7; j <= 14; j++)
                paths[1][0][8][j] = true;
            // end- level 2 random 1
            // level 2 random 2    
            for (int j = 0; j <= 4; j++)
            {
                paths[1][1][0][j] = true;
                paths[1][1][4][j+4] = true;
            }           
            for (int j = 8; j <= 14; j++)
                paths[1][1][7][j] = true;
            for (int i = 0; i <= 4; i++)
                paths[1][1][i][4] = true;
            for (int i = 4; i <= 7; i++)
                paths[1][1][i][8] = true;
            for (int i = 7; i <= 9; i++)
                paths[1][1][i][14] = true;
            // end- level 2 random 2
            // level 2 random 3                        
            for (int i = 0; i <= 1; i++)
            {
                paths[1][2][i][0] = true;
                paths[1][2][i+2][0] = true;
                paths[1][2][i+4][0] = true;
                paths[1][2][i+5][3] = true;
                paths[1][2][i + 6][3] = true;
                paths[1][2][i + 6][8] = true;
                paths[1][2][i + 6][12] = true;
                paths[1][2][i + 8][12] = true;

            }
            for (int j = 0; j <= 1; j++)
            {
                paths[1][2][5][j] = true;
                paths[1][2][5][j+2] = true;
                paths[1][2][6][j+8] = true;
                paths[1][2][6][j + 10] = true;
                paths[1][2][7][j + 4] = true;
                paths[1][2][7][j + 6] = true;
                paths[1][2][9][j + 13] = true;
            }
            // end- level 2 random 3
            // level 2 random 4                        
            for (int i = 0; i <= 3; i++)
            {
                paths[1][3][i][2] = true;
                paths[1][3][i+6][8] = true;
                paths[1][3][i + 3][9] = true; 

            }
            for (int j = 0; j <= 2; j++)
            {
                paths[1][3][0][j] = true;
                paths[1][3][3][j+3] = true;
                paths[1][3][3][j + 6] = true;
                paths[1][3][9][j + 9] = true;
                paths[1][3][9][j + 12] = true;
            }
            // end- level 2 random 4
            // level 2 random 5         
            for (int j = 0; j <= 14; j++)
                paths[1][4][0][j] = true;
            for (int i = 0; i <= 2; i++)
            {
                paths[1][4][i][14] = true;
                paths[1][4][i+2][12] = true;
                paths[1][4][i + 4][10] = true;
                paths[1][4][i + 6][9] = true;

            }
            for (int j = 0; j <= 2; j++)
            {
                paths[1][4][2][j + 12] = true;
                paths[1][4][4][j + 10] = true;
                paths[1][4][9][j + 9] = true;
                paths[1][4][9][j + 12] = true;
            }
            // end- level 2 random 5            
            // level 3 random 1         
            for (int j = 0; j <= 1; j++)
            {
                paths[2][0][0][j] = true;
                paths[2][0][9][j+13] = true;
            }
            for (int j = 0; j <= 3; j++)
            {
                paths[2][0][8][j+4] = true;
                paths[2][0][4][j + 9] = true;
            }
            for (int i = 0; i <= 2; i++)
            {
                paths[2][0][i][1] = true;
                paths[2][0][i+2][2] = true;
                paths[2][0][i+4][3] = true;
                paths[2][0][i+6][4] = true;
                paths[2][0][i+6][7] = true;
                paths[2][0][i+4][8] = true;
                paths[2][0][i+5][12] = true;
                paths[2][0][i+7][13] = true;
            }
            // end- level 3 random 1
            // level 3 random 2                     
            for (int j = 0; j <= 2; j++)
            {
                paths[2][1][3][j] = true;
                paths[2][1][1][j+2] = true;
                paths[2][1][2][j+7] = true;
                paths[2][1][6][j+5] = true;
                paths[2][1][7][j+10] = true;
                paths[2][1][9][j+12] = true;
            }
            for (int i = 0; i <= 2; i++)
            {
                paths[2][1][i][0] = true;
                paths[2][1][i+1][2] = true;
                paths[2][1][i+1][4] = true;
                paths[2][1][i+4][4] = true;
                paths[2][1][i+3][7] = true;
                paths[2][1][i+2][9] = true;
                paths[2][1][i+5][9] = true;
                paths[2][1][i+7][12] = true;
            }
            // end- level 3 random 2
            // level 3 random 3                     
            for (int j = 0; j <= 3; j++)
            {
                paths[2][2][3][j] = true;
                paths[2][2][0][j+4] = true;
                paths[2][2][5][j+8] = true;
                paths[2][2][9][j+11] = true;
            }
            for (int i = 0; i <= 2; i++)
            {
                paths[2][2][i][0] = true;
                paths[2][2][i][3] = true;
                paths[2][2][i][7] = true;
                paths[2][2][i+3][7] = true;
                paths[2][2][i+5][12] = true;
                paths[2][2][i+7][11] = true;
            }
            // end- level 3 random 3
            // level 3 random 4
            for (int j = 0; j <= 1; j++)
            {
                paths[2][3][0][j] = true;
                paths[2][3][j+8][14] = true;
            }
            for (int j = 0; j <= 2; j++)
            {
                paths[2][3][9][j] = true;
                paths[2][3][7][j+3] = true;
                paths[2][3][4][j+6] = true;
                paths[2][3][9][j+9] = true;
                paths[2][3][8][j+11] = true;
            }
            for (int i = 0; i <= 2; i++)
            {
                paths[2][3][i][1] = true;
                paths[2][3][i+2][0] = true;
                paths[2][3][i+5][0] = true;
                paths[2][3][i+7][0] = true;
                paths[2][3][i+7][2] = true;
                paths[2][3][i+4][5] = true;
                paths[2][3][i+4][9] = true;
                paths[2][3][i+7][9] = true;
            }
            // end- level 3 random 4
            // level 3 random 5            
            for (int j = 0; j <= 2; j++)
            {
                paths[2][4][3][j] = true;
                paths[2][4][3][j+2] = true;
                paths[2][4][0][j+4] = true;
                paths[2][4][5][j+4] = true;
                paths[2][4][7][j+4] = true;
                paths[2][4][9][j+7] = true;
                paths[2][4][7][j+11] = true;
            }
            for (int i = 0; i <= 2; i++)
            {
                paths[2][4][i][0] = true;
                paths[2][4][i][4] = true;
                paths[2][4][i][6] = true;
                paths[2][4][i+3][6] = true;
                paths[2][4][i+5][4] = true;
                paths[2][4][i+7][6] = true;
                paths[2][4][i+7][10] = true;
                paths[2][4][i+7][14] = true;

            }
            // end- level 3 random 5
        }

        private void BtnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            for(int i=1;i<=icell;i++)
            dgvCells.Rows.Add();            
            dgvCells.Rows[0].Cells[0].Selected = false;            
            
        }       
        private void dgvCells_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if(dgvCells.CurrentCell.Style.BackColor==Color.FromArgb(224, 224, 224))
                dgvCells.CurrentCell.Style.BackColor = Color.Red;
            else
                dgvCells.CurrentCell.Style.BackColor = Color.FromArgb(224, 224, 224);
            dgvCells.CurrentCell.Selected = false;
            btnCLR.Enabled = true;
            if (dgvCells.Rows[0].Cells[0].Style.BackColor == Color.Red
                && dgvCells.Rows[9].Cells[14].Style.BackColor == Color.Red)
            {
                btnShow.Enabled = true;
                if (randCounter <= 1)
                    lblPath.Visible = true;
            }
        }

        private void btnCLR_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < rcell; i++)
                for (int j = 0; j < icell; j++)
                    dgvCells.Rows[j].Cells[i].Style.BackColor = Color.FromArgb(224, 224, 224);            
            dgvCells.Rows[0].Cells[0].Selected = false;
            dgvCells.CurrentCell.Selected = false;
            btnCLR.Enabled = false;
            btnShow.Enabled = false;
            lblPath.Visible = false;
        }

        private void btnStart_Click(object sender, EventArgs e)
        {
            dgvCells.Enabled = false;
            lblScore.Visible = false;
            //clearing
            for (int i = 0; i < rcell; i++)
                for (int j = 0; j < icell; j++)
                    dgvCells.Rows[j].Cells[i].Style.BackColor = Color.FromArgb(224, 224, 224);
            dgvCells.Rows[0].Cells[0].Selected = false;
            dgvCells.CurrentCell.Selected = false;
            //timer            
            if (randCounter == 4)
            {
                currentLev++;
                randCounter = -1;
            }
            if (currentLev == 3)
            {
                timer1.Enabled = true;
                lblScore.Text = "Your Score is: " + score;
                lblScore.Visible = true;
                MessageBox.Show("You Finished the Game Successfully. Congratulation!!!", "End of Game",
                    MessageBoxButtons.OK, MessageBoxIcon.Information);
                btnStart.Enabled = false;
                btnCLR.Enabled = false;
                btnShow.Enabled = false;
                dgvCells.Enabled = false;
                lblWin.Text = "You Win the Game!";
                return;
            }
            currentRand = randomArr[++randCounter];
            btnStart.Enabled = false;
            timer.Enabled = true;
            lblLost.Visible = false;
            lblWin.Visible = false;
            lblPath.Visible = false;
        }

        private void timer_Tick(object sender, EventArgs e)
        {            
            lblTimer.Text = "";
            if (timerCounter == 0)
            {
                lblTimer.Visible = true;
                lblTimer.Text = "Level " + (randCounter +(currentLev*5)+ 1);
                pbLev.Value = randCounter + (currentLev * 5) + 1;
            }
            else if (timerCounter == 1)
            {
                lblTimer.Text = "3";
                pbLev.Value--;
            }
            else if (timerCounter == 2)
            {
                lblTimer.Text = "2";
                pbLev.Value++;
            }
            else if (timerCounter == 3)
            {
                lblTimer.Text = "1";
                pbLev.Value--;
            }
            else if (timerCounter == 4)
            {
                pbLev.Value++;
                lblTimer.Visible = false;
                lbl5Sec.Visible = true;
                //drawing path
                for (int i = 0; i < icell; i++)
                    for (int j = 0; j < rcell; j++)
                        if (paths[currentLev][currentRand][i][j])
                            dgvCells.Rows[i].Cells[j].Style.BackColor = Color.Green;

            }
            else if (timerCounter == 5)
                lbl5Sec.Text = "4";
            else if (timerCounter == 6)
                lbl5Sec.Text = "3";
            else if (timerCounter == 7)            
                lbl5Sec.Text = "2";                
            else if (timerCounter == 8)            
                lbl5Sec.Text = "1";                            
            else if (timerCounter == 9)
            {
                timerCounter = -1;
                timer.Enabled = false;
                lbl5Sec.Visible = false;
                dgvCells.Enabled = true;
                //clearing
                for (int i = 0; i < rcell; i++)
                    for (int j = 0; j < icell; j++)
                        dgvCells.Rows[j].Cells[i].Style.BackColor = Color.FromArgb(224, 224, 224);
            }
            timerCounter++;
        }

        private void btnShow_Click(object sender, EventArgs e)
        {
            bool isWinner = true;
            for (int i = 0; i < icell; i++)
                for (int j = 0; j < rcell; j++)
                    if (paths[currentLev][currentRand][i][j])
                        if (dgvCells.Rows[i].Cells[j].Style.BackColor == Color.FromArgb(224, 224, 224))
                        {
                            isWinner = false;                            
                        }
                        else
                        {
                            score++;
                        }
                    else if (dgvCells.Rows[i].Cells[j].Style.BackColor == Color.Red)
                    {
                        isWinner = false;                        
                    }
            for (int i = 0; i < icell; i++)
                for (int j = 0; j < rcell; j++)
                    if (paths[currentLev][currentRand][i][j])
                        dgvCells.Rows[i].Cells[j].Style.BackColor = Color.GreenYellow;
            if (isWinner)
            {
                lblWin.Visible = true;
                btnStart.Text = "Next Level";
            }
            else
            {
                lblLost.Visible = true;
                btnStart.Text = "Start Again";
                currentLev = 0;
                randCounter = -1;
                currentRand = -1;
                pbLev.Value = 0;
                lblScore.Text = "Your Score is: " + score;
                lblScore.Visible = true;
                if (topScore <= score)
                {
                    topScore = score;
                    lblTopScore.Text = "Top Score: " + topScore;
                }
                score = 0;
            }            
            dgvCells.CurrentCell.Selected = false;
            dgvCells.Enabled = false;
            btnCLR.Enabled = false;
            btnShow.Enabled = false;
            btnStart.Enabled = true;
            lblPath.Visible = false;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (lblUOK.BackColor == Color.FromArgb(78, 100, 255))
                lblUOK.BackColor = this.BackColor;
            else
                lblUOK.BackColor = Color.FromArgb(78, 100, 255);
        }

        private void lblPath_Click(object sender, EventArgs e)
        {
            lblPath.Visible = false;
        }          
    }
}
