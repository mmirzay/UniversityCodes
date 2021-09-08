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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            FormEsh fs = new FormEsh();
            fs.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void enter_Click(object sender, EventArgs e)
        {
            if(comboBax.SelectedIndex==0){
                if (txtUser.Text == "" && txtPass.Text == "")
                {
                    new Manager().ShowDialog();
                }
                else {

                    MessageBox.Show("اطلاعات وارد شده صحیح نیست!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                }            
            }
            if(comboBax.SelectedIndex==1){
                FileStream fs = new FileStream("user_account.txt", FileMode.OpenOrCreate, FileAccess.Read);
                StreamReader sr = new StreamReader(fs);
                String line = sr.ReadLine();
                bool found = false;
                while (line != null)
                {
                    String[] client = line.Split(',');
                    if (client[0].Equals(txtUser.Text) && client[1].Equals(txtPass.Text))
                    {
                        FileStream ff = new FileStream("curent.txt", FileMode.Create, FileAccess.Write);
                        StreamWriter sw = new StreamWriter(ff);
                        sw.WriteLine(client[0]);
                        sw.Close();
                        ff.Close();

                        String clientType = "",fn="";
                        if (client[2].Equals("homeUser"))
                        {
                            clientType = "کاربر خانگی";
                            fn = "home_client.txt";
                        }
                        else
                        {
                            clientType = "کاربر سازمانی";
                            fn = "organization_client.txt";
                        }                        
                        FileStream fs2 = new FileStream(fn, FileMode.OpenOrCreate, FileAccess.Read);
                        StreamReader sr2 = new StreamReader(fs2);
                        String line2 = sr2.ReadLine();
                        bool found2 = false;
                        while (line2 != null)
                        {
                            String[] client2 = line2.Split(',');
                            if (client2[0].Equals(txtUser.Text))
                            {
                                if (clientType.Equals("کاربر خانگی"))
                                    new HomeClientUser().ShowDialog();
                                else
                                    new OrgClientUser().ShowDialog();
                                found2 = true;
                                break;
                            }
                            line2 = sr2.ReadLine();
                        }
                        sr2.Close();
                        fs2.Close();
                        if (!found2) MessageBox.Show("اشتراک شما در حال حاضر توسط مدیر تایید نشده است.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                         MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                        found = true;
                        break;
                    }
                    line = sr.ReadLine();
                }
                sr.Close();
                fs.Close();
                if (!found) MessageBox.Show("اطلاعات وارد شده صحیح نیست!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                         MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
            }
            txtUser.Text = "";
            txtPass.Text = "";
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void comboBax_SelectedIndexChanged(object sender, EventArgs e)
        {
            txtUser.Text = "";
            txtPass.Text = "";
        }
    }
}
