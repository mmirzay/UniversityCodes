using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace tamrine_11
{
    public partial class showBill : Form
    {
        public showBill()
        {
            InitializeComponent();
        }
        private void showBill_Load(object sender, EventArgs e)
        {
        }

        private void label1_Click(object sender, EventArgs e)
        {
            
            FileStream fsr = new FileStream("bill.txt", FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader srr = new StreamReader(fsr);
            FileStream cu = new FileStream("curent.txt", FileMode.Open, FileAccess.Read);
            StreamReader cr = new StreamReader(cu);
            String number = cr.ReadLine();
            label1.Text = number;
            string line = srr.ReadLine();
            while (line != null)
            {
                string[] client = line.Split(',');
                if (number.Equals(client[0]))
                    line = srr.ReadLine();
            }
            
            srr.Close();
            fsr.Close();
            cu.Close();
            cr.Close();
        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
