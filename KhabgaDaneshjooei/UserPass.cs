using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace KhabgaDaneshjooei
{
    public partial class UserPass : Form
    {
        public UserPass()
        {
            InitializeComponent();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnVorood_Click(object sender, EventArgs e)
        {
            if (txtUser.Text.Equals("1") && txtPass.Text.Equals("1"))
                this.Close();
            else
                MessageBox.Show("نام کاربری و رمز عبور اشتباه است", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
    }
}
