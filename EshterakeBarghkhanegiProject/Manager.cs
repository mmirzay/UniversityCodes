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
    public partial class Manager : Form
    {
        public Manager()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnContinue_Click(object sender, EventArgs e)
        {
            if (rdbSuppShow.Checked == true)
                new SuppList().ShowDialog();
            else if (rdbAccShow.Checked == true)
                new ClientList().ShowDialog();
            else if (rdbInsertRes.Checked == true)
                new bill().Show();
        }
    }
}
