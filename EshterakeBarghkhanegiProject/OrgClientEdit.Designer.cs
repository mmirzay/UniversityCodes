namespace tamrine_11
{
    partial class OrgClientEdit
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.bnSabt = new System.Windows.Forms.Button();
            this.txtPass = new System.Windows.Forms.TextBox();
            this.txtUser = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.btnCancel = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.gbOrg = new System.Windows.Forms.GroupBox();
            this.cmbOrgType = new System.Windows.Forms.ComboBox();
            this.txtOrgName = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtOrgPost = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtOrgNamayande = new System.Windows.Forms.TextBox();
            this.txtOrgTel = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.gbOrg.SuspendLayout();
            this.SuspendLayout();
            // 
            // bnSabt
            // 
            this.bnSabt.Location = new System.Drawing.Point(98, 349);
            this.bnSabt.Name = "bnSabt";
            this.bnSabt.Size = new System.Drawing.Size(75, 20);
            this.bnSabt.TabIndex = 13;
            this.bnSabt.Text = "ثبت";
            this.bnSabt.UseVisualStyleBackColor = true;
            this.bnSabt.Click += new System.EventHandler(this.bnSabt_Click);
            // 
            // txtPass
            // 
            this.txtPass.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtPass.Location = new System.Drawing.Point(11, 59);
            this.txtPass.Name = "txtPass";
            this.txtPass.ReadOnly = true;
            this.txtPass.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.txtPass.Size = new System.Drawing.Size(261, 20);
            this.txtPass.TabIndex = 13;
            this.txtPass.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // txtUser
            // 
            this.txtUser.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtUser.Location = new System.Drawing.Point(11, 22);
            this.txtUser.Name = "txtUser";
            this.txtUser.ReadOnly = true;
            this.txtUser.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.txtUser.Size = new System.Drawing.Size(261, 20);
            this.txtUser.TabIndex = 12;
            this.txtUser.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("2  Mitra", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label6.Location = new System.Drawing.Point(383, 59);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(58, 23);
            this.label6.TabIndex = 13;
            this.label6.Text = "رمز عبور :";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("2  Mitra", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label1.Location = new System.Drawing.Point(371, 22);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(70, 23);
            this.label1.TabIndex = 12;
            this.label1.Text = "نام کاربری :";
            // 
            // btnCancel
            // 
            this.btnCancel.Location = new System.Drawing.Point(17, 349);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(75, 20);
            this.btnCancel.TabIndex = 14;
            this.btnCancel.Text = "انصراف";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.txtUser);
            this.groupBox1.Controls.Add(this.txtPass);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(17, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.groupBox1.Size = new System.Drawing.Size(447, 87);
            this.groupBox1.TabIndex = 12;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "اطلاعات کابری";
            // 
            // gbOrg
            // 
            this.gbOrg.Controls.Add(this.cmbOrgType);
            this.gbOrg.Controls.Add(this.txtOrgName);
            this.gbOrg.Controls.Add(this.label2);
            this.gbOrg.Controls.Add(this.txtOrgPost);
            this.gbOrg.Controls.Add(this.label3);
            this.gbOrg.Controls.Add(this.txtOrgNamayande);
            this.gbOrg.Controls.Add(this.txtOrgTel);
            this.gbOrg.Controls.Add(this.label7);
            this.gbOrg.Controls.Add(this.label8);
            this.gbOrg.Controls.Add(this.label9);
            this.gbOrg.Location = new System.Drawing.Point(12, 105);
            this.gbOrg.Name = "gbOrg";
            this.gbOrg.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.gbOrg.Size = new System.Drawing.Size(447, 219);
            this.gbOrg.TabIndex = 15;
            this.gbOrg.TabStop = false;
            this.gbOrg.Text = "اطلاعات سازمان";
            // 
            // cmbOrgType
            // 
            this.cmbOrgType.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbOrgType.FormattingEnabled = true;
            this.cmbOrgType.Items.AddRange(new object[] {
            "آموزشی",
            "تولیدی",
            "اداری"});
            this.cmbOrgType.Location = new System.Drawing.Point(54, 56);
            this.cmbOrgType.Name = "cmbOrgType";
            this.cmbOrgType.Size = new System.Drawing.Size(218, 21);
            this.cmbOrgType.TabIndex = 2;
            // 
            // txtOrgName
            // 
            this.txtOrgName.Location = new System.Drawing.Point(54, 19);
            this.txtOrgName.Name = "txtOrgName";
            this.txtOrgName.Size = new System.Drawing.Size(218, 20);
            this.txtOrgName.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("2  Mitra", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label2.Location = new System.Drawing.Point(363, 16);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(66, 23);
            this.label2.TabIndex = 0;
            this.label2.Text = "نام سازمان";
            // 
            // txtOrgPost
            // 
            this.txtOrgPost.Location = new System.Drawing.Point(54, 93);
            this.txtOrgPost.Name = "txtOrgPost";
            this.txtOrgPost.Size = new System.Drawing.Size(218, 20);
            this.txtOrgPost.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("2  Mitra", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label3.Location = new System.Drawing.Point(321, 166);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(110, 23);
            this.label3.TabIndex = 9;
            this.label3.Text = "شماره تلفن ضروری";
            // 
            // txtOrgNamayande
            // 
            this.txtOrgNamayande.Location = new System.Drawing.Point(54, 130);
            this.txtOrgNamayande.Name = "txtOrgNamayande";
            this.txtOrgNamayande.Size = new System.Drawing.Size(218, 20);
            this.txtOrgNamayande.TabIndex = 4;
            // 
            // txtOrgTel
            // 
            this.txtOrgTel.Location = new System.Drawing.Point(54, 167);
            this.txtOrgTel.Name = "txtOrgTel";
            this.txtOrgTel.Size = new System.Drawing.Size(218, 20);
            this.txtOrgTel.TabIndex = 5;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("2  Mitra", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label7.Location = new System.Drawing.Point(361, 54);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(68, 23);
            this.label7.TabIndex = 7;
            this.label7.Text = "نوع سازمان";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("2  Mitra", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label8.Location = new System.Drawing.Point(328, 130);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(101, 23);
            this.label8.TabIndex = 5;
            this.label8.Text = "شماره ملی نماینده";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("2  Mitra", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label9.Location = new System.Drawing.Point(374, 92);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(55, 23);
            this.label9.TabIndex = 6;
            this.label9.Text = "کد پستی";
            // 
            // OrgClientEdit
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(480, 380);
            this.Controls.Add(this.gbOrg);
            this.Controls.Add(this.bnSabt);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "OrgClientEdit";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "ویرایش مشترک سازمانی";
            this.Load += new System.EventHandler(this.OrgClientEdit_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.gbOrg.ResumeLayout(false);
            this.gbOrg.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button bnSabt;
        private System.Windows.Forms.TextBox txtPass;
        private System.Windows.Forms.TextBox txtUser;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox gbOrg;
        private System.Windows.Forms.ComboBox cmbOrgType;
        private System.Windows.Forms.TextBox txtOrgName;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtOrgPost;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtOrgNamayande;
        private System.Windows.Forms.TextBox txtOrgTel;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
    }
}