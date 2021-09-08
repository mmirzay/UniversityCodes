using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace RGBColors
{
    public partial class Form1 : Form
    {
        static bool isRed = false;
        static bool isGreen = false;
        static bool isBlue = false;
        static bool isMax = false;        
        static int rcounter=0,gcounter=0,bcounter=0;
        public Form1()
        {
            InitializeComponent();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnBlend_Click(object sender, EventArgs e)
        {
            int r = int.Parse(txtRed.Text);
            int g = int.Parse(txtGreen.Text);
            int b = int.Parse(txtBlue.Text);
            this.BackColor = Color.FromArgb(r, g, b);
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            
            if (!isRed && !isGreen && !isBlue)
                timer1.Enabled = false;
            if (isRed)
                txtRed.Text = "" + (int.Parse(txtRed.Text) + rcounter);
            if (isGreen)
                txtGreen.Text = "" + (int.Parse(txtGreen.Text) + gcounter);
            if (isBlue)
                txtBlue.Text = "" + (int.Parse(txtBlue.Text) + bcounter);
            int r = int.Parse(txtRed.Text);
            int g = int.Parse(txtGreen.Text);
            int b = int.Parse(txtBlue.Text);
            if (r > 255)
            {
                txtRed.Text="255";
                r = 255;
                isRed = false;
            }
            if (r < 0)
            {
                txtRed.Text = "0";
                r = 0;
                isRed = false;
            }
            if (g > 255)
            {
                txtGreen.Text = "255";
                g = 255;
                isGreen = false;
            }
            if (g < 0)
            {
                txtGreen.Text = "0";
                g = 0;
                isGreen = false;
            }
            if (b > 255)
            {
                txtBlue.Text = "255";
                b = 255;
                isBlue = false;
            }
            if (b < 0)
            {
                txtBlue.Text = "0";
                b = 0;
                isBlue = false;
            }
            this.BackColor = Color.FromArgb(r, g, b);
        }

        private void btnMaxRed_Click(object sender, EventArgs e)
        {
            rcounter = 1;
            timer1.Enabled = true;
            isRed = true;
        }

        private void btnMinRed_Click(object sender, EventArgs e)
        {
            timer1.Enabled = true;
            rcounter = -1;
            isRed = true;
        }

        private void btnMaxGreen_Click(object sender, EventArgs e)
        {
            timer1.Enabled = true;
            gcounter = 1;
            isGreen = true;
        }

        private void btnMinGreen_Click(object sender, EventArgs e)
        {
            timer1.Enabled = true;
            gcounter = -1;
            isGreen = true;
        }

        private void btnMaxBlue_Click(object sender, EventArgs e)
        {
            timer1.Enabled = true;
            bcounter = 1;
            isBlue = true;
        }

        private void btnMinBlue_Click(object sender, EventArgs e)
        {
            timer1.Enabled = true;
            bcounter = -1;
            isBlue = true;
        }
    }
}
