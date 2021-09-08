namespace tamrine_11
{
    partial class Form1
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
            this.label1 = new System.Windows.Forms.Label();
            this.btenter = new System.Windows.Forms.Button();
            this.txtUser = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.txtPass = new System.Windows.Forms.TextBox();
            this.comboBax = new System.Windows.Forms.ComboBox();
            this.btexit = new System.Windows.Forms.Button();
            this.bttagh = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label1.Location = new System.Drawing.Point(65, 29);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(299, 24);
            this.label1.TabIndex = 0;
            this.label1.Text = "سیستم مدیریت صورتحساب مشترکین اداره برق";
            // 
            // btenter
            // 
            this.btenter.Location = new System.Drawing.Point(137, 262);
            this.btenter.Name = "btenter";
            this.btenter.Size = new System.Drawing.Size(75, 23);
            this.btenter.TabIndex = 4;
            this.btenter.Text = "ورود";
            this.btenter.UseVisualStyleBackColor = true;
            this.btenter.Click += new System.EventHandler(this.enter_Click);
            // 
            // txtUser
            // 
            this.txtUser.Location = new System.Drawing.Point(163, 161);
            this.txtUser.Name = "txtUser";
            this.txtUser.Size = new System.Drawing.Size(121, 20);
            this.txtUser.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label2.Location = new System.Drawing.Point(82, 133);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(68, 16);
            this.label2.TabIndex = 3;
            this.label2.Text = "نوع کاربری";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label3.Location = new System.Drawing.Point(86, 165);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(64, 16);
            this.label3.TabIndex = 4;
            this.label3.Text = "نام کاربری";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(178)));
            this.label4.Location = new System.Drawing.Point(94, 197);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(56, 16);
            this.label4.TabIndex = 5;
            this.label4.Text = "کلمه عبور";
            // 
            // txtPass
            // 
            this.txtPass.Location = new System.Drawing.Point(163, 193);
            this.txtPass.Name = "txtPass";
            this.txtPass.PasswordChar = '*';
            this.txtPass.Size = new System.Drawing.Size(121, 20);
            this.txtPass.TabIndex = 3;
            // 
            // comboBax
            // 
            this.comboBax.DisplayMember = "1";
            this.comboBax.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboBax.FormattingEnabled = true;
            this.comboBax.Items.AddRange(new object[] {
            "مدیریت",
            "مشترک"});
            this.comboBax.Location = new System.Drawing.Point(163, 128);
            this.comboBax.Name = "comboBax";
            this.comboBax.Size = new System.Drawing.Size(121, 21);
            this.comboBax.TabIndex = 1;
            this.comboBax.Tag = "";
            this.comboBax.SelectedIndexChanged += new System.EventHandler(this.comboBax_SelectedIndexChanged);
            // 
            // btexit
            // 
            this.btexit.Location = new System.Drawing.Point(244, 262);
            this.btexit.Name = "btexit";
            this.btexit.Size = new System.Drawing.Size(75, 23);
            this.btexit.TabIndex = 6;
            this.btexit.Text = "خروج";
            this.btexit.UseVisualStyleBackColor = true;
            this.btexit.Click += new System.EventHandler(this.button2_Click);
            // 
            // bttagh
            // 
            this.bttagh.Location = new System.Drawing.Point(137, 324);
            this.bttagh.Name = "bttagh";
            this.bttagh.Size = new System.Drawing.Size(182, 29);
            this.bttagh.TabIndex = 5;
            this.bttagh.Text = "تقاضای اشتراک جدید";
            this.bttagh.UseVisualStyleBackColor = true;
            this.bttagh.Click += new System.EventHandler(this.button3_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDark;
            this.ClientSize = new System.Drawing.Size(422, 392);
            this.Controls.Add(this.comboBax);
            this.Controls.Add(this.bttagh);
            this.Controls.Add(this.btexit);
            this.Controls.Add(this.txtPass);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtUser);
            this.Controls.Add(this.btenter);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "صفحه ی نخست";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btenter;
        private System.Windows.Forms.TextBox txtUser;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtPass;
        private System.Windows.Forms.Button btexit;
        private System.Windows.Forms.Button bttagh;
        private System.Windows.Forms.ComboBox comboBax;
    }
}

