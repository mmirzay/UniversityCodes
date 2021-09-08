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
    public partial class HomeClientEdit : Form
    {
        String cnum = "";
        public HomeClientEdit(String cn)
        {
            cnum = cn;
            InitializeComponent();
        }

        private void HomeClientEdit_Load(object sender, EventArgs e)
        {
            FileStream fs = new FileStream("user_account.txt", FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader sr = new StreamReader(fs);
            String line = sr.ReadLine();
            while (line != null)
            {
                String[] client = line.Split(',');
                if (client[0].Equals(cnum))
                {
                    txtUser.Text = client[0];
                    txtPass.Text = client[1];
                    break;
                }
                line = sr.ReadLine();
            }            
            sr.Close();
            fs.Close();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        public void writeEditedHomeInfo(String cn, String nam, String lnam, String id, String post, String tell, String unit)
        {
            FileStream fs = new FileStream("home_client.txt", FileMode.OpenOrCreate, FileAccess.ReadWrite);
            FileStream fs2 = new FileStream("temp.txt", FileMode.Create, FileAccess.Write);
            StreamReader fsrr = new StreamReader(fs);
            StreamWriter fsw = new StreamWriter(fs2);
            String linee = fsrr.ReadLine();
            while (linee != null)
            {
                String[] client = linee.Split(',');
                if (cn.Equals(client[0]))
                {
                    fsw.WriteLine(cn + "," + nam + "," + lnam + "," + id + "," + post + "," + tell + "," + unit);
                }
                else
                    fsw.WriteLine(linee);
                linee = fsrr.ReadLine();
            }
            fsrr.Close();
            fsw.Close();
            fs.Close();
            fs2.Close();
            File.Delete("home_client.txt");
            File.Move("temp.txt", "home_client.txt");
            File.Delete("temp.txt");
        }
        private void bnSabt_Click(object sender, EventArgs e)
        {
            if (id_txtBox.Text.Equals("") || name_txtBox.Text.Equals("") ||
                    lastName_txtBox.Text.Equals("") || tell_txtBox.Text.Equals("") ||
                    txtPostalCode.Text.Equals("") || txtUnit.Text.Equals(""))
                MessageBox.Show("لطفا اطلاعات را کامل وارد کنید!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                    MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
            else
            {
                String id = id_txtBox.Text;
                String name = name_txtBox.Text;
                String lastName = lastName_txtBox.Text;
                String postCode = txtPostalCode.Text;
                String tell = tell_txtBox.Text;
                String unit = txtUnit.Text;                
                writeEditedHomeInfo(cnum,name, lastName, id, postCode, tell, unit);
                MessageBox.Show("اطلاعات ویرایش شد!","ثبت اطلاعات", MessageBoxButtons.OK, MessageBoxIcon.Information,
                    MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                this.Dispose();
                new ClientList().ShowDialog();
            }                        
        }
    }
}
