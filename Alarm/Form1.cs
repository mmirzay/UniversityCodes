using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Alarm
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit(new CancelEventArgs(true));
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            timer1.Enabled = true;
            DateTime time = DateTime.Now;
            lblTime.Text = time.Hour + ":" + time.Minute + ":" + time.Second;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            DateTime time = DateTime.Now;
            lblTime.Text = time.Hour + ":" + time.Minute + ":" + time.Second;
            if (cmbMin.SelectedItem != null && cmbHour.SelectedItem != null &&
                time.Hour == int.Parse("" + cmbHour.SelectedItem) &&
                time.Minute == int.Parse("" + cmbMin.SelectedItem))
            {

                this.Show();
                this.WindowState = FormWindowState.Normal;
                if (this.BackColor == Color.MediumTurquoise)
                    this.BackColor = Color.Red;
                else
                    this.BackColor = Color.MediumTurquoise;
                Console.Beep();
            }
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Minimized;
            this.Hide();
            notifyIcon1.ShowBalloonTip(1000);
            lblAlarm.Visible = true;
            if (cmbMin.SelectedItem==null || cmbHour.SelectedItem==null)
                lblAlarm.Text = "Choose an Hour: Minute to Alarm";
            else
                lblAlarm.Text = "Alarm at: " + cmbHour.SelectedItem + " hr : " + cmbMin.SelectedItem + " min";
        }

        private void notifyIcon1_MouseDoubleClick(object sender, MouseEventArgs e)
        {

            this.Show();
            this.WindowState = FormWindowState.Normal;
        }
    }
}
