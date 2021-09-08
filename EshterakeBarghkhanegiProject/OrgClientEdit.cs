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
    public partial class OrgClientEdit : Form
    {
        String cnum;
        public OrgClientEdit(String cn)
        {
            cnum = cn;
            InitializeComponent();
        }
        public void writeEditedOrgInfo(String cn, String nam, String typ, String post, String id, String tell)
        {
            FileStream fs = new FileStream("organization_client.txt", FileMode.OpenOrCreate, FileAccess.ReadWrite);
            FileStream fs2 = new FileStream("temp.txt", FileMode.Create, FileAccess.Write);
            StreamReader fsrr = new StreamReader(fs);
            StreamWriter fsw = new StreamWriter(fs2);
            String linee = fsrr.ReadLine();
            while (linee != null)
            {
                String[] client = linee.Split(',');
                if (cn.Equals(client[0]))
                {
                    fsw.WriteLine(cn + "," + nam + "," + typ + "," + post + "," + id + "," + tell);
                }
                else
                    fsw.WriteLine(linee);
                linee = fsrr.ReadLine();
            }
            fsrr.Close();
            fsw.Close();
            fs.Close();
            fs2.Close();
            File.Delete("organization_client.txt");
            File.Move("temp.txt", "organization_client.txt");
            File.Delete("temp.txt");
        }
        private void OrgClientEdit_Load(object sender, EventArgs e)
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

        private void bnSabt_Click(object sender, EventArgs e)
        {
            if (txtOrgName.Text.Equals("") || cmbOrgType.Text.Equals("") ||
                    txtOrgPost.Text.Equals("") || txtOrgNamayande.Text.Equals("") ||
                    txtOrgTel.Text.Equals(""))
                MessageBox.Show("لطفا اطلاعات را کامل وارد کنید!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                    MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
            else
            {
                String strOrgName = txtOrgName.Text;
                String strOrgType = cmbOrgType.Text;
                String strOrgPost = txtOrgPost.Text;
                String strOrgNamayande = txtOrgNamayande.Text;
                String strOrgTel = txtOrgTel.Text;                
                writeEditedOrgInfo(cnum,strOrgName, strOrgType, strOrgPost, strOrgNamayande, strOrgTel);
                MessageBox.Show("اطلاعات ویرایش گردید!",
                    "ثبت اطلاعات", MessageBoxButtons.OK, MessageBoxIcon.Information,
                    MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                this.Dispose();
                new ClientList().ShowDialog();
            }
        }
    }
}
